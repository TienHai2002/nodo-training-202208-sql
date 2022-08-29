package dao.impl;


import dao.StudentDAO;
import model.Student;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentDAOImpl implements StudentDAO, DisposableBean {
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;
    @PostConstruct
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
    @Override
    public void insert(Student student) {
        jdbcTemplate.update("INSERT INTO haint1_student(ID,NAME,AGE) VALUES (haint1_student_SEQ.NEXTVAL,?,?)",student.getName(),student.getAge());
        System.out.println("Created Record Name = "+student.getName());
    }

    @Override
    public List<Student> list() {
        List<Student> studentList = new ArrayList<Student>();
        String sql ="SELECT * FROM haint1_student";
        studentList = jdbcTemplate.query(sql,new StudentRowMapper());
        return  studentList;
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.execute("DELETE FROM haint1_student WHERE ID="+id);
    }

    @Override
    public Student getById(Integer id) {
        StudentRowMapper mapper = new StudentRowMapper();
        return jdbcTemplate.queryForObject("SELECT * FROM haint1_student WHERE ID= "+id,mapper);
    }

    @Override
    public void destroy() throws Exception {
        DriverManager.getConnection("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
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
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }
    }
}