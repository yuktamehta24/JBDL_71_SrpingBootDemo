package org.gfg.JBDL_71_SrpingBootDemo;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBBean {

    @Bean
    public Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/JBDL_71",
                                "root", "rootroot");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/JBDL_71");
//        dataSource.setUsername("root");
//        dataSource.setPassword("rootroot");
//        return dataSource;
//    }
}
