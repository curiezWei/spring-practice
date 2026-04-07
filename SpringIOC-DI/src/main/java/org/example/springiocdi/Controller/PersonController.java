package org.example.springiocdi.Controller;

import org.example.springiocdi.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private Person person;
    @RequestMapping("checkInfo")
    public String checkInfo(){
        return "information of person is :"+person ;
    }
}
