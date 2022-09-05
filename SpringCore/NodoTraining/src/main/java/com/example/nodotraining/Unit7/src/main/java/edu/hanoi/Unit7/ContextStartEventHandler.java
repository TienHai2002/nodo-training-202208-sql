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
    DatabaseMetaData databaseMetaData;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("b1");
        try{
            createTable("haint_group","create table haint_group (" +
                    "    id number(4) primary key," +
                    "    name varchar2(100)" +
                    ")");
        }catch (Exception e){
            LOGGER.error(e,e);
            e.printStackTrace();
        }
        LOGGER.info("-- Context start application "+dataSource);
    }

    private void createTable(String name, String script) throws SQLException {
        databaseMetaData = dataSource.getConnection().getMetaData();
        ResultSet rs = databaseMetaData.getTables(null,null,name,null);
        if(rs.next()){
            LOGGER.info("haint_student "+rs.getString("name")+" already exists!");
            return;
        }
        jdbcTemplate.update(script);
    }
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DatabaseMetaData getDatabaseMetaData() {
        return databaseMetaData;
    }

    public void setDatabaseMetaData(DatabaseMetaData databaseMetaData) {
        this.databaseMetaData = databaseMetaData;
    }

    public ContextStartEventHandler(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public ContextStartEventHandler(){}
}

