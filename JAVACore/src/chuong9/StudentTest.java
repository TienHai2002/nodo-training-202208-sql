package chuong9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


public class StudentTest {
    public static List<Student> filter(List<Student> students, Filter<Student> pred) {
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (pred.valid(student)) {
                list.add(student);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, "Tran Van A"));
        students.add(new Student(21, "Tran Van B"));
        students.add(new Student(20, "Tran Van C"));
        students.add(new Student(19, "Tran Van D"));

//        chuong9.Filter<chuong9.Student> older = student -> student.getAge() <= 30;
//        List<chuong9.Student> filtered = filter(students, older);
//        for (chuong9.Student student : filtered){
//            System.out.println(student);
//        }
//        Collections.sort(students,(chuong9.Student student1,chuong9.Student student2) ->student1.getAge() - student2.getAge());
//        students.forEach(student -> System.out.println(student));

//        Stream<chuong9.Student> stream = students.stream().sorted((chuong9.Student student1, chuong9.Student student2) -> student1.getAge() - student2.getAge());
//        System.out.println(stream);

        Comparator<Student> comparator = (student1,student2)->student1.getAge()- student2.getAge();
        Stream<Student> stream =students.stream().sorted(comparator);
        stream.forEach(student -> System.out.println(student));

        System.out.println("\n Max is " + students.stream().max(comparator));
        int sum = students.stream().mapToInt(Student :: getAge).sum();
        System.out.println("Average og age is " + sum/students.size());
        students.parallelStream().forEach((it) -> System.out.println( Thread.class + " hello : " + it.getName()));
    }
}
