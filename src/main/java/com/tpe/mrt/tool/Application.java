package com.tpe.mrt.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.tpe.mrt.tool")
@EntityScan("com.tpe.mrt.tool")
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = "com.tpe.mrt.tool")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
