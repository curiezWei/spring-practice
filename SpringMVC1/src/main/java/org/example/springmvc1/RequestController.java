package org.example.springmvc1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    //传对象
    @RequestMapping("/r4")
    public String r4(Person person) {
        return "personal information: "+ person;
    }

    //参数取别名，前端传name，后端用userName
    //强制传
    @RequestMapping("/r5")
    public String r5(@RequestParam("name")String userName) {
        return "name is "+userName;
    }

    //非强制传
    @RequestMapping("/r6")
    public String r6(@RequestParam(value = "name",required = false)String userName) {
        return "name is "+userName;
    }
}
