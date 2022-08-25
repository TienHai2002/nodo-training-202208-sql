package com.example.nodotraining.Unit2;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentJDBCDAO {
    public static Logger LOGGER = Logger.getLogger(StudentJDBCDAO.class);
    private String insertQuery;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private PlatformTransactionManager transactionManager = new PlatformTransactionManager() {
        @Override
        public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
            return null;
        }

        @Override
        public void commit(TransactionStatus status) throws TransactionException {

        }

        @Override
        public void rollback(TransactionStatus status) throws TransactionException {

        }
    };

    private void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private void createTableIfNotExist() {
        try {
            DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "TIENHAI_STUDENT", null);
            if (rs.next()) {
                System.out.println("Table " + rs.getString("TIENHAI_STUDENT") + "Already exist!");
                return;
            }
//            jdbcTemplate.execute("CREATE TABLE HAINT1_STUDENT (\n" +
//                    "  ID number  NOT NULL PRIMARY KEY,\n" +
//                    "  NAME varchar2(50),\n" +
//                    "  AGE number \n" +
//                    ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(int id, String name, Integer age) {
        jdbcTemplate.update(insertQuery, id, name, age);
        LOGGER.info("Create record name= " + name + " Age= " + age);
    }


    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int totalRecord() {
        return jdbcTemplate.execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
                ResultSet rs = stmt.executeQuery("select count(*) from  haint1_student");
                return rs.next() ? rs.getInt(1) : 0;
            }
        });
    }

    private final static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            } catch (Exception e) {
                LOGGER.error(e, e);
                return mapRow(rs, rowNum);
            }

        }
    }

    public List loadStudent(String name) {
        return jdbcTemplate.query("SELECT *FROM haint1_STUDENT WHERE NAME LIKE '%" + name + "%'", new StudentRowMapper());
    }

    public int[] add(List<Student> students) {

        List<Object[]> batch = new ArrayList<>();
        students.forEach(student -> batch.add(new Object[]{
                student.getId(), student.getName(), student.getAge()
        }));
        return jdbcTemplate.batchUpdate(insertQuery, batch);
    }

    public void save(Object id, Object name, Object age) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        String countQuery =("select count(*) from  haint1_student");
        try {
            Integer total = jdbcTemplate.queryForObject(countQuery,Integer.class);
            LOGGER.info("before save data  , total record is " + total );
            LOGGER.info("===============================================" );

            String sql = "INSERT INTO HAINT1_STUDENT(id,name,age) VALUES(?,?,?)";
            jdbcTemplate.update(sql,id,name,age);

            total = jdbcTemplate.queryForObject(countQuery,Integer.class);
            LOGGER.info("after save data  , total record is " + total );

            String countQuery2 =("select count(*) from  haint1_student");
            Integer total2 = jdbcTemplate.queryForObject(countQuery2,Integer.class);
            transactionManager.commit(status);
        }catch (Exception e){
            transactionManager.rollback(status);
            Integer total = jdbcTemplate.queryForObject(countQuery,Integer.class);
            LOGGER.info("after save data  , total record is " + total );

        }
    }

}
