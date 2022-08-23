import oracle.jdbc.rowset.OracleJDBCRowSet;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcRowSetEx {
    public static void main(String[] args) throws Exception{
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
        jdbcRowSet.setUrl("jdbc:oracle:thin:SCOTT/SCOTT@27.118.22.14:1521:orcl");
        jdbcRowSet.setCommand("select * from HAINT_STUDENT");
        jdbcRowSet.execute();
//        while (jdbcRowSet.next()){
//            System.out.println(jdbcRowSet.getInt(1)+"\t"+jdbcRowSet.getString("NAME"));
//
//        }
//        jdbcRowSet.close();

        jdbcRowSet.first();
        jdbcRowSet.updateString("name","Nguyen Tien X");
        jdbcRowSet.commit();

        jdbcRowSet.first();
        System.out.println(jdbcRowSet.getInt("ID")+ "\t" +jdbcRowSet.getInt(2));

        jdbcRowSet.absolute(8);
        System.out.println(jdbcRowSet.getInt("NAME") + ":" + jdbcRowSet.getInt("AGE"));

        jdbcRowSet.close();

    }
}
