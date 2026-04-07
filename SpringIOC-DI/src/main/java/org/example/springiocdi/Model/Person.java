package org.example.springiocdi.Model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("student")
@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;
}
