package org.example.springiocdi.Model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("listtype")
@Data
public class ListConfig {
    private List<String> name;
    private Map<String,Integer> map;
}
