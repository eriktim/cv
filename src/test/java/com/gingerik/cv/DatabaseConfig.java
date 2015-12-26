package com.gingerik.cv;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class DatabaseConfig {

  @Autowired
  DataSource dataSource;

  @Bean
  public DatabaseConfigBean dbUnitDatabaseConfig() {
    final DatabaseConfigBean dbConfig = new DatabaseConfigBean();
    dbConfig.setCaseSensitiveTableNames(true);
    return dbConfig;
  }

  @Bean
  public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection() {
    final DatabaseDataSourceConnectionFactoryBean connection = new DatabaseDataSourceConnectionFactoryBean();
    connection.setDataSource(this.dataSource);
    connection.setDatabaseConfig(this.dbUnitDatabaseConfig());
    return connection;
  }
}