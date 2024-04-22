package Springboot.Bookstore.Util_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration(value = "JDBC_class_bean_by_sumit")  // this is bean name defined for test
//@ConfigurationProperties(prefix = "spring.datasource")
@PropertySource("classpath:application.properties")
public class SpringJDBC_util_config {

    @Value("${spring.datasource.url}")
     String url;

    @Value("${spring.datasource.username}")
     String username;

    @Value("${spring.datasource.password}")
     String password;

    @Value("${spring.datasource.driver-class-name}")
     String jdbcDriver;

    @Bean(value = "JDBC_method_getJDBCConn_bean_by_sumit") // @Bean is mostly used in @COnfiguration class
    public DataSource getDataSource_for_SpringJDBC() {
        DriverManagerDataSource dms1 = new DriverManagerDataSource(url, username, password);
        dms1.setDriverClassName(jdbcDriver);
        return dms1;
    }


}




/*
            Another way:
            
                @Value("${spring.datasource.driver-class-name}")
                private String jdbcDriver;

                @Bean(value = "JDBC_method_getJDBCConn_bean_by_sumit") // @Bean is mostly used in @COnfiguration class
                public DataSource getJDBCconn(
                        @Value("${spring.datasource.url}") String url,
                        @Value("${spring.datasource.username}") String user ,
                        @Value("${spring.datasource.password}") String pass) {
                    DriverManagerDataSource dms1 = new DriverManagerDataSource(url, user, pass);
                    dms1.setDriverClassName(jdbcDriver);
                    return dms1;
                }
 */