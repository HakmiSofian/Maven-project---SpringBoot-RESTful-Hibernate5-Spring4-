package tv.alphanetworks.exo.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = {
        @ComponentScan("tv.alphanetworks.exo.dao"),
        @ComponentScan("tv.alphanetworks.exo.service")})
public class DatabaseConfiguration {


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource( dataSource() );
        sessionFactory.setPackagesToScan(
                new String[] { "tv.alphanetworks.exo.model" } );
        sessionFactory.setHibernateProperties( hibernateProperties() );

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSourceConfig = new BasicDataSource();
        dataSourceConfig.setDriverClassName( "com.mysql.jdbc.Driver" );

        dataSourceConfig.setUrl( "jdbc:mysql://localhost:3306/public" );
        dataSourceConfig.setUsername( "sofian" );
        dataSourceConfig.setValidationQuery( "SELECT 1" );
        dataSourceConfig.setPassword( "admin" );

        return dataSourceConfig;
    }



    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(
            SessionFactory sessionFactory ) {

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory( sessionFactory );

        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties hibernateProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.put( "hibernate.dialect", "org.hibernate.dialect.MySQLDialect" );
        jpaProperties.put( "hibernate.show_sql", "false" );
        jpaProperties.put( "hibernate.format_sql", "true" );

        return jpaProperties;
    }

}
