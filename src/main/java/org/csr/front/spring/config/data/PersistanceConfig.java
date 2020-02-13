package org.csr.front.spring.config.data;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-orcl.properties" })
@ComponentScan({ "org.csr.back.model" })
public class PersistanceConfig {
	
	private Logger logger = LogManager.getLogger("SPRING_BASE_WEB_APP_LOGGER");
	
	@Autowired
	private Environment env;
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() throws SQLException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {"org.csr.back.model"});
        sessionFactory.setHibernateProperties(hibernateProperties());
 
        return sessionFactory;
    }
 
    @Bean
    public DataSource dataSource() throws SQLException {
    	logger.debug("restDataSource...");
//      dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		OracleDataSource dataSource = new OracleDataSource();
		logger.debug(String.format("jdbc.url %s", env.getProperty("jdbc.url")));
		dataSource.setURL(env.getProperty("jdbc.url"));
		logger.debug(String.format("jdbc.user %s", env.getProperty("jdbc.user")));
		dataSource.setUser(env.getProperty("jdbc.user"));
		logger.debug(String.format("jdbc.pass %s", env.getProperty("jdbc.pass")));
		dataSource.setPassword(env.getProperty("jdbc.pass"));

		return dataSource;
    }
 
    @Bean
    public PlatformTransactionManager hibernateTransactionManager() throws SQLException {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
 
    private final Properties hibernateProperties() {
    	logger.debug("hibernateProperties...");
		Properties properties = new Properties();
		logger.debug(String.format("hibernate.dialect %s", env.getProperty("hibernate.dialect")));
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		logger.debug(String.format("hibernate.show_sql %s", env.getProperty("hibernate.show_sql")));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return properties;
    }
}
