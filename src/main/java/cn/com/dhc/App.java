package cn.com.dhc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App{
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    @Bean(destroyMethod = "close",initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

}

