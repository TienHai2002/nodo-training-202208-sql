import java.sql.*;

public class UpdateDataEx {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
        try {
            conn = DriverManager.getConnection(url, "SCOTT", "SCOTT");
            PreparedStatement statement = conn.prepareStatement("update haint_student set  name = ? where id = ?");
            statement.setString(1,"le van luyen");
            statement.setInt(2,2);
            statement.executeUpdate();
        } catch (SQLException e) {
            conn.close();
        }

    }
}
