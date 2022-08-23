import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WebRowSetEx {
    public static void main(String[] args) throws Exception {
        Connection connection = null;
        WebRowSet wrs = null;
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            System.out.println("Driver Loading...");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl", "SCOTT", "SCOTT");
            System.out.println("Connect Successful!");
            Statement statement = connection.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("select * from HAINT_STUDENT");
            String file = "output.xml";
            FileWriter writer = new FileWriter(file);
            wrs = RowSetProvider.newFactory().createWebRowSet();
            wrs.writeXml(rs, writer);

            Desktop.getDesktop().open(new File(file));

        } finally {
            wrs.close();
        }
    }
}
