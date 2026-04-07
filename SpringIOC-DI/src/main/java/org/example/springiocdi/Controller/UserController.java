package org.example.springiocdi.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${mykey}")
    private String key;

    public void method() {
        System.out.println("User Controller: mykey is "+key );
    }
}
