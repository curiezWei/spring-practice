package org.example.springiocdi.Repository;

import org.springframework.stereotype.Repository;

@Repository//一般用于数据库
public class GetSomeData {
    public void doRepository(){
        System.out.println("let's get some data");
    }
}
