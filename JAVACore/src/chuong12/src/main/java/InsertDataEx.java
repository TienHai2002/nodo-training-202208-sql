import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataEx {
    public static void main(String[] args) throws SQLException {


        try {
            String url = "jdbc:oracle:thin:@27.118.22.14:1521:orcl";
            Connection conn = DriverManager.getConnection(url,"SCOTT","SCOTT");
            Statement statement = conn.createStatement();

            statement.execute("insert into haint_student(id,genereted,name,age) values (2,2,'Hoang Viet Anh',20)");
            statement.execute("insert into haint_student(id,genereted,name,age) values (3,3,'Viet Tien Vuong',20)");
            statement.execute("insert into haint_student(id,genereted,name,age) values (4,4,'Doan Thanh Tu',20)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
