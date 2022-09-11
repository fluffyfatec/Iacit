package com.fluffyiacit.api;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/db_teste");
		dataSource.setUsername("postgres");
		dataSource.setPassword("123");
		
		return dataSource;
	}

	@Bean
	public JpaVendorAdapter jpaVendorApapter() {
		HibernateJpaVendorAdapter jpaVendor = new HibernateJpaVendorAdapter();
		jpaVendor.setGenerateDdl(false);
		jpaVendor.setShowSql(false);
		jpaVendor.setDatabasePlatform("org.hibernate.dialect.PostgreSQL94Dialect");
		return jpaVendor;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.fluffyiacit.api.modal");
		emf.setJpaVendorAdapter(jpaVendorApapter());
		emf.setJpaProperties(jpaProperties());
		return emf;
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
//		properties.put("hibernate.show_sql", "false");
//		properties.put("hibernate.hbm2ddl.auto", "validate");
//MOSTRA AS QUERY SQL QUE SÃO RODADAS
		properties.put("hibernate.show_sql", "true");
//CRIA AS TABELAS A PARTIR DA MODAL
//		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManager);
		return transactionManager;
	}

}
