package dao.impl;

import dao.StudentDAO;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@Component
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    public void setDataSource(){

    }


@PostConstruct
    @Override
    public void insert(Student student) {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    }
}
