package com.shopify.ShoppingBackend.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement  //@EnableTransactionManagement and <tx:annotation-driven/> are responsible for registering the necessary Spring components that power annotation-driven transaction management
@ComponentScan({"com.shopify.ShoppingBackend.dao"})

public class HibernateConfig {
	
	
	        private final static String  DATABASE_DRIVER="oracle.jdbc.driver.OracleDriver";
			private final static String	DATABASE_URL="jdbc:oracle:thin:@localhost:1521:XE";
			private final static String DATABSE_password="Prity@13";
			private final static String DATABASE_USERNAME="SYSTEM";


			private final static String hibernate_dialect="org.hibernate.dialect.Oracle10gDialect";
			private final static String hibernate_showSQL="true";
			private final static String hibernate_format_sql="true";
			private final static String hibernate_hbm2ddl_auto="update";	

	@Bean
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(DATABASE_DRIVER);
		ds.setUrl(DATABASE_URL);
		ds.setUsername(DATABASE_USERNAME);
		ds.setPassword(DATABSE_password);
		System.out.println("Connected");
		return ds;
	}
	
	

	@Bean
	public SessionFactory getsessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder lb=new LocalSessionFactoryBuilder(datasource);
		lb.addProperties(getHibernateProperties());
		lb.scanPackages("com.shopify.ShoppingBackend.dto");
	     return lb.buildSessionFactory();
		}
	
 
	private Properties getHibernateProperties() {
	   Properties prop=new Properties();
	   prop.put("hibernate.dialect", hibernate_dialect);
	   prop.put("hibernate.showsql",hibernate_showSQL);
	   prop.put("hibernate.format_sql", hibernate_format_sql);
	   prop.put("hibernate.hbm2ddl.auto",hibernate_hbm2ddl_auto);
	   System.out.println("Table created ");
	   return prop;
	  }
	
   @Bean
   @Autowired
   public HibernateTransactionManager transactionManager(SessionFactory sf) {
	   HibernateTransactionManager hbm=new HibernateTransactionManager(sf);
	    return hbm;
   }
   
   
   
}