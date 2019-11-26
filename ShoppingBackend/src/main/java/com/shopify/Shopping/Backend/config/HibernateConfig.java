package com.shopify.Shopping.Backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages ="com.shopify.shopping.Backend.config")
@EnableTransactionManagement
public class HibernateConfig {
	private final static String DATABASE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	private final static String DATABASE_DRIVER="oracle.jdbc.driver.OracleDriver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.Oracle10gDialect";
	private final static String DATABASE_USERNAME="SYSTEM";
	private final static String DATABASE_PASSWORD="Prity@13";

	@Bean 
	public DataSource getDataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		//Proving the dataSource connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
    
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder =new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		
		return builder.buildSessionFactory();
	}
   //All the hibernate properties are returned in this method
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
	    return properties;
	}

	
	@Bean 
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hbm=new HibernateTransactionManager(sessionFactory);
		return hbm;
	}
	
	
	
	
}
