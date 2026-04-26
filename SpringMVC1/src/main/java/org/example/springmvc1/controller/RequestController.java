package org.example.springmvc1.controller;

import org.example.springmvc1.model.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    //接收json
    @RequestMapping("/r7")
    public String r7(@RequestBody Person person) {
        return "personal information: "+person;
    }

    //从路径中获取参数,url中不用带键值对
    @RequestMapping("/r8/{id}/{name}")
    public String r8(@PathVariable("id") Integer id,@PathVariable("name") String name) {
        return "path var is "+ id+" "+name;
    }

    //上传文件
    @RequestMapping("/r9")
    public String r9(@RequestPart("file") MultipartFile imageFile) {
        String fileName = imageFile.getOriginalFilename();
        return fileName;
    }
}
