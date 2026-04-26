package org.example.springmvc1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cal")
public class CalculatorController {
    @RequestMapping("/sum")
    public String sum(Integer num1,Integer num2){
        Integer sum = num1+num2;
        return "和为："+sum;
    }
}
