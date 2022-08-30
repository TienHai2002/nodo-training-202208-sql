package edu.hanoi.Unit7;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContextStartEventHandler implements ApplicationListener<ContextStartedEvent> {
    private final static Logger LOGGER = Logger.getLogger(ContextStartEventHandler.class);
    @Autowired
    private DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        try {

        }catch(Exception e) {

        }
//        LOGGER.info("context start application" + dataSource);
    }
    private void create(String name,String script) throws SQLException {
        DatabaseMetaData dmbd =dataSource.getConnection().getMetaData();
        ResultSet rs = dmbd.getTables(null,null,name,null);
        if (rs.next()){
            LOGGER.info("Table" + rs.getString("") + "already exits1");
            return;
        }
        dataSource.getConnection().createStatement().executeUpdate(script);
    }
}
