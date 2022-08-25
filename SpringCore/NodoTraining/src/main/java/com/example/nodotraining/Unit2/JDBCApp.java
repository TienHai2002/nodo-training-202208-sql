package com.example.nodotraining.Unit2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JDBCApp {
    public static void main(String[] args) {

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            StudentJDBCDAO jdbcdao = (StudentJDBCDAO) context.getBean("studentJDBCDAO");
            List<Student> students = new ArrayList<>();
            System.out.println("create bean " + jdbcdao);

//        jdbcdao.insert(1,"Nguyen Tien Hai" , 30);


            System.out.println("=========================================================");
//            jdbcdao.loadStudent("A").forEach(student -> StudentJDBCDAO.LOGGER.info(student));
//            students.add(new Student(2,"Ha Viet ANh",20));
//            students.add(new Student(3,"Doan Thanh Tu",20));
//            students.add(new Student(4,"Nguyen Danh Vinh",20));
//            int[] values = jdbcdao.add(students);
//            for (int i = 0 ;i <values.length;i++){
//                StudentJDBCDAO.LOGGER.info("add record : " + i + " : " + (values[i] ==0 ? "failed" : "success"));
//            }
            System.out.println("Total student is " + jdbcdao.totalRecord());
            jdbcdao.save(6,"Tran 1Thi A" ,23);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
