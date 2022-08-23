import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchProcessingEx {
    public static void main(String[] args) throws Exception{
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        System.out.println("Driver Loading...");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl","SCOTT","SCOTT");
        System.out.println("Connect Successful!");
        Statement statement = con.createStatement();

        for (int i = 3; i < 20; i++) {
            int id = 5+i;
            String name = " TRAN VAN "+i+"";
            int age = 10+i;

            String sql = "insert into HAINT_STUDENT values ("+ id +","+ name +","+ age  +")";
            statement.addBatch(sql);
        }
        statement.executeBatch();
        ResultSet rs;
        rs = statement.executeQuery("select count(*) from HAINT_STUDENT");
        if (rs.next()) System.out.println("Total records = " +rs.getInt(1));
        con.close();

    }
}
