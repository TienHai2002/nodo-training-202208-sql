import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcMetadataEx {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String dbUrl = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
            String username = "SCOTT";
            String password = "SCOTT";
            conn = DriverManager.getConnection(dbUrl, "SCOTT", "SCOTT");
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("db version " + metaData.getDatabaseMajorVersion());
            System.out.println("driver name " + metaData.getDriverName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
