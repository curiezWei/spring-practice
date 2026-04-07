package org.example.springiocdi.Controller;

import org.example.springiocdi.Model.ListConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

    @Autowired
    private ListConfig listConfig;

    @RequestMapping("checkType")
    public String checkType(){
        return listConfig.toString();
    }
}
