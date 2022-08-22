import java.sql.*;

public class TransactionEx {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;

        String url = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
        try {
            conn = DriverManager.getConnection(url, "SCOTT", "SCOTT");
            PreparedStatement statement = conn.prepareStatement("insert into haint_student(id,genereted,name,age) values ()");

            conn.setAutoCommit(false);
            for (int i = 0 ; i < 10 ; i++){
                String name = "Tran Van " + i;
                int age = 10 + i;
                statement.executeUpdate("insert into haint_student (name,age) values " + "(" + name + ", " + age + " )");
            }
            conn.rollback();
            conn.setAutoCommit(true);
            rs = statement.executeQuery("select count(*) from haint_student");
            if (rs.next()){
                System.out.println("total record = " + rs.getInt(1));

            }
        } catch (SQLException e) {
           conn.close();
        }
    }
}
