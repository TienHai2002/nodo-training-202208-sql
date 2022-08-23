import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;

public class DataAccessLogicDataTest {
    public static void main(String[] args) throws Exception {
        DataAccessLogic data = new DataAccessLogic();
//        List<String> names = data.loadNames(1);
//        names.forEach(System.out::println);

        IntStream.range(1,data.numberOfPage()+1).forEach(page ->{
            System.out.println("==========================" +page);
            List<String> names = null;
            try {
                names = data.loadNames(page);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println(names);
        });
    }
}
