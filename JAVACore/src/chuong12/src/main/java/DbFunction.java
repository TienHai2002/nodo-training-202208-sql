import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbFunction {
    public static void getAge(String name,int[] ages) throws Exception{
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        System.out.println("Driver Loading...");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        System.out.println("Connect Successful!");
        Statement statement = connection.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("select max(AGE) from HAINT_STUDENT where NAME like '%"+name+"%'");
        ages[0] = rs.next() ? rs.getInt(1) : -1;
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        int[] ages = new int[1];
        getAge("Quang Duong",ages);
        System.out.println(ages[0]);
    }
}
