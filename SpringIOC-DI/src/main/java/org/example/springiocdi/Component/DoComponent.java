package org.example.springiocdi.Component;

import org.springframework.stereotype.Component;

@Component("DoComponent")//手动指认名字，不然默认是首字母为小写：doComponent
public class DoComponent {
    public void method(){
        System.out.println("this is a component");
    }
}
//component意思为组件，加上了@Component注解就是给spring管理的意思（放在了beans里面）
