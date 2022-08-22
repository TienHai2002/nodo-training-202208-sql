import java.sql.*;

public class SelectDataEx {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        try {
            String url = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
            conn = DriverManager.getConnection(url, "SCOTT", "SCOTT");
            Statement statement = conn.createStatement();
            rs = statement.executeQuery("select * from haint_student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + "\t" + name + "\t" + age);
            }
        } catch (SQLException e) {
            rs.close();
            conn.close();
        }
    }
}
