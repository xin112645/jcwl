package com.dww.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.beans.PropertyVetoException;
@Configuration
@MapperScan("com.jfxb.dao")
public class DataSourceConfiguration {

    @Value("${jdbc.Driver}")
    private String jdbcDriver;
    @Value("${jdbc.Url}")
    private String jdbcUrl;
    @Value("${jdbc.Username}")
    private String jdbcUsername;
    @Value("${jdbc.Password}")
    private String jdbcPassword;
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        dataSource.setAutoCommitOnClose(false);//关闭连接后不自动提交
        return dataSource;
    }
}
