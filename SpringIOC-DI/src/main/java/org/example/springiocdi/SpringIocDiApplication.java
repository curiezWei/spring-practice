package org.example.springiocdi;

import org.example.springiocdi.Component.DoComponent;
import org.example.springiocdi.Controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocDiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIocDiApplication.class,args);
//        ApplicationContext context = SpringApplication.run(SpringIocDiApplication.class, args);
//        DoComponent bean = (DoComponent) context.getBean("DoComponent");
//        bean.method();
//        UserController bean2 = (UserController) context.getBean("userController");
//        bean2.method();
    }

}
