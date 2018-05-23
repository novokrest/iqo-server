package com.iqoption.server.config

import javax.sql.DataSource

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.{Bean, Primary}
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.support.TransactionTemplate

class StorageConfiguration {

  @Primary
  @Bean
  @ConfigurationProperties(prefix = "spring.masterDataSource")
  def masterDataSource: DataSource = DataSourceBuilder.create.build

  @Bean
  def masterJdbcTemplate(masterDataSource: DataSource) = new JdbcTemplate(masterDataSource)

  @Bean
  def masterTransactionManager(masterDataSource: DataSource) = new DataSourceTransactionManager(masterDataSource)

  @Bean
  def masterTransactionTemplate(masterTransactionManager: DataSourceTransactionManager) = new TransactionTemplate(masterTransactionManager)

  @Bean
  @ConfigurationProperties(prefix = "spring.slaveDataSource")
  def slaveDataSource: DataSource = DataSourceBuilder.create.build

  @Bean
  def slaveJdbcTemplate(slaveDataSource: DataSource) = new JdbcTemplate(slaveDataSource)
}
