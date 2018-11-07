package com.matmazur.springdemo;

import com.matmazur.springdemo.datasource.DatabaseDatasource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {

//        --- Was working in prework without using Spring Boot---
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext((SpringDemoApplication.class));
        ConfigurableApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);

        DatabaseDatasource ds = context.getBean(DatabaseDatasource.class);

        List<String> list = ds.getDatabase();
        list.forEach(System.out::println);

        System.out.println("Some nonsense");

        context.close();
    }
}
