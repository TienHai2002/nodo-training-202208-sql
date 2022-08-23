import java.sql.*;

public class SelectDataEx {
    private static ResultSet rs;

    public static void main(String[] args) throws Exception{
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        System.out.println("Driver Loading...");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl","SCOTT","SCOTT");
        System.out.println("Connect Successful!");

        Statement statement = con.createStatement();
        rs = statement.executeQuery("SELECT * FROM HAINT_STUDENT");
        while (rs.next()){
            Integer id = rs.getInt("ID");
            String name = rs.getString("NAME");
            Integer age = rs.getInt("AGE");

            System.out.println(id +"\t" + name +"\t" +age);
        }
        rs.close();
        con.close();
    }
}
