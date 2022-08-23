import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataEx {
    public static void main(String[] args) throws Exception{
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        System.out.println("Driver Loading...");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl","SCOTT","SCOTT");
        System.out.println("Connect Successful!");

        Statement statement = con.createStatement();
        statement.execute("INSERT INTO HAINT_STUDENT(ID,NAME,AGE) values (1,'Nguyen Tien Hai',21)");
        statement.execute("INSERT INTO HAINT_STUDENT(ID,NAME,AGE) values (2,'Nguyen Danh Vinh',20)");
        statement.execute("INSERT INTO HAINT_STUDENT(ID,NAME,AGE) values (3,'Doan Thanh Tu  ',20)");
        statement.execute("INSERT INTO HAINT_STUDENT(ID,NAME,AGE) values (4,'Ha Viet Anh  ',20)");
        System.out.println(statement.execute("SELECT * FROM HAINT_STUDENT"));
        System.out.println("Insert Successfully!");
        statement.close();
        con.close();

    }
}
