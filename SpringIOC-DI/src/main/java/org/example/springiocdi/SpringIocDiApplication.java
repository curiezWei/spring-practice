package org.example.springiocdi;

import org.example.springiocdi.Controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocDiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringIocDiApplication.class, args);
        UserController bean = context.getBean(UserController.class);
        bean.method();
    }

}
