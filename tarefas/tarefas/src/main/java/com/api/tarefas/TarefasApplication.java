package com.api.tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TarefasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TarefasApplication.class, args);
    }

}
