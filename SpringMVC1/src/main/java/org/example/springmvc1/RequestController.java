package org.example.springmvc1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/request")
@RestController
public class RequestController {
    @RequestMapping("/hello")
    public String say () {
        return "hello SpringMVC";
    }

    @RequestMapping("/r1")
    public String r1(String name) {
        return "name is "+ name;
    }

    @RequestMapping("/r2")
    public String r2(Integer age) {
        return "age is "+age;
    }

    @RequestMapping("/r3")
    public String r3(int age) {
        return "age is " + age;
    }

}
