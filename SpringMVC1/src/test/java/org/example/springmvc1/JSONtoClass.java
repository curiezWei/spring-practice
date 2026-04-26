package org.example.springmvc1;

import org.example.springmvc1.model.Person;
import tools.jackson.databind.ObjectMapper;

public class JSONtoClass {
    public static void main(String[] args) {
        String jsonString = "{\"id\":114514,\"name\":\"curiez\",\"age\":20}";
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(jsonString, Person.class);
        System.out.println(person);
        String string = objectMapper.writeValueAsString(person);
        System.out.println(string);
    }
}
