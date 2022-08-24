package com.example.nodotraining.Unit2;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
public class StudentJDBCDAO {
     public Logger LOGGER;
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private void createTableIfNotExist() {
        try {
            DatabaseMetaData dbmd = dataSource.getConnection().getMetaData();
            ResultSet rs = dbmd.getTables(null, null, "STUDENT", null);
            if (rs.next()) {
                System.out.println("Table " + rs.getString("TABLE_NAME") + "Already exist!");
                return;
            }
            jdbcTemplate.execute("CREATE TABLE TIENHAI_STUDENT (" +
                    " + id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ( START WITH 1, INCREMENT BY 1)," + " name varchar(1000), " + " age INTEGER)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void setDataSource(DriverManagerDataSource dataSource) {
    }

}
