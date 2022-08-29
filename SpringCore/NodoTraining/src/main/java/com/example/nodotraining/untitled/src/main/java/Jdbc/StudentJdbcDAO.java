package Jdbc;
import model.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.StatementCallback;
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
public class StudentJdbcDAO {
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
    private String insertQuery;
    private String deleteQuery;
    private String updateQuery;
    @Autowired
    DataSource dataSource;
    static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void createTableIfNotExist() throws SQLException {
        DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "haint1_student", null);
        if (rs.next()) {
            System.out.println("Table " + rs.getString("TABLE_NAME") + " already exists !");
            return;
        }
        String sql = "create table haint1_student"
                + "("
                + "id int primary key ,"
                + "name varchar(255),"
                + "age int"
                + ")";
//        jdbcTemplate.execute(sql);
    }


    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Integer id, String name, Integer age) {
        jdbcTemplate.update(insertQuery, id, name, age);
        System.out.println("Created Record Name = " + id + "Name" + name + "Age" + age);
    }

    public void setInsertQuery(String insertQuery) {
        this.insertQuery = insertQuery;
    }

    public int totalRecord() {
        return jdbcTemplate.execute(new StatementCallback<Integer>() {
            @Override
            public Integer doInStatement(Statement stmt) throws SQLException, DataAccessException {
                ResultSet rs = stmt.executeQuery("select count(*) from haint1_student");
                return rs.next() ? rs.getInt(1) : 0;
            }
        });
    }

    public void setUpdateQuery(String updateQuery) {
        this.updateQuery = updateQuery;
    }

    public void setDeleteQuery(String deleteQuery) {
        this.deleteQuery = deleteQuery;
    }

    private final static class StudentRowMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            try {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                return student;
            }catch (Exception e){
                e.printStackTrace();
                LOGGER.error(e ,e);
                return null;
            }
        }
    }
    public List<Student> loadStudent(String name){
        return jdbcTemplate.query("SELECT * FROM haint1_student WHERE NAME LIKE '%"+name+"%'",new StudentRowMapper());
    }

    public void update(Integer age, String name) {
        jdbcTemplate.update(updateQuery, age, name);
        System.out.println("Update Record Name = Name" + name + "Age" + age);
    }
    public void delete(Integer id){
        jdbcTemplate.update(deleteQuery,id);
        System.out.println("Delete id :"+id);
    }
    public int[] add(List<Student> students){
        List<Object[]> batch =new ArrayList<>();
        students.forEach(student -> batch.add(new Object[]{
                student.getId(),student.getName(),student.getAge()
        }));
        return jdbcTemplate.batchUpdate(insertQuery,batch);
    }
    public void save(Object id,Object name, Object age){
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        String coutQuery = "SELECT COUNT(*) FROM haint1_student";
        try{
            Integer total = jdbcTemplate.queryForObject(coutQuery, Integer.class);
            System.out.println("Before save data, total records is "+total);
            String sql = "INSERT INTO haint1_student(id,name,age) values (?,?,?)";
            jdbcTemplate.update(sql,id,name,age);
            Integer total1 = jdbcTemplate.queryForObject(coutQuery, Integer.class);
            System.out.println("Aflter save data, total records is "+total1);

            transactionManager.commit(status);
        }catch (Exception e){
            transactionManager.rollback(status);
            Integer total = jdbcTemplate.queryForObject(coutQuery, Integer.class);
            System.out.println("After rollback, total records is "+total);
        }
    }
}
