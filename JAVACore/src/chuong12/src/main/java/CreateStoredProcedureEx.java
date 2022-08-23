import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateStoredProcedureEx {
    public static void main(String[] args) throws Exception{
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        System.out.println("Driver Loading...");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
        System.out.println("Connect Successful!");
        Statement statement = connection.createStatement();
        statement.executeUpdate("create procedure getAge001(stream_name varchar(100),OUT AGE INT)"+
                "PARAMETER STYLE JAVA READs" +
                "SQL DATA LANGUAGE JAVA EXTERNAL NAME"+
                "'jdbc.DbFunction.getAge'");
        System.out.println("Done!");
        connection.close();
    }
}
