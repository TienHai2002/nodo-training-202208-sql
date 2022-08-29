package Jdbc;

import model.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class jdbcApp {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
    }
}
