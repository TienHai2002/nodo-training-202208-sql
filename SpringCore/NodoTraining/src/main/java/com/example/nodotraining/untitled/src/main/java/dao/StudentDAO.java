package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {
    public void insert(Student student);
    public List<Student> list();
    public void deleteById(Integer id);
    public Student getById(Integer id);
}
