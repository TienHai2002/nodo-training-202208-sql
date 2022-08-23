import oracle.jdbc.rowset.OracleCachedRowSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class DataAccessLogic {
    private final static Logger logger = Logger.getLogger(DataAccessLogic.class.getName());
    Connection connection = null;
    CachedRowSet rowSet;

    public DataAccessLogic() throws Exception{
        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@27.118.22.14:1521:orcl","SCOTT","SCOTT");
        rowSet = RowSetProvider.newFactory().createCachedRowSet();
        rowSet.setCommand("select * from HAINT_STUDENT");
        rowSet.execute(connection);
    }
    public void disconnect()throws Exception{
        try {
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            logger.log(Level.WARNING,e.toString());
        }
    }
    Integer pageSize = 10;
    List<String> loadNames(int page) throws SQLException {
        List names = new ArrayList();
        rowSet.setPageSize(pageSize);
        int start = (page -1)*pageSize +1;
        if (!rowSet.absolute(start)){
            return names;
        }
        rowSet.previous();
        while (rowSet.next()){
            names.add(rowSet.getString("name"));
            if (names.size() >= pageSize){
                break;
            }
        }
        return  names;
    }
    int numberOfPage() throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("select count(*) from HAINT_STUDENT");
            if (!rs.next()){
                return 0;
            }
            int total = rs.getInt(1);
            int totalPage = total/pageSize;
            if (total%pageSize != 0){
                totalPage++;
            }
            return  totalPage;
        } finally {
            statement.close();
        }

    }
}
