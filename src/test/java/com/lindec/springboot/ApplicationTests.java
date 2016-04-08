package com.lindec.springboot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lindec.springboot.repository.Person;
import com.lindec.springboot.repository.PersonRepository;
import com.lindec.springboot.utils.HttpTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private Environment env;

    @Test
    public void contextLoads() {
        Person person = personRepository.findByName("lindec");
//		Person person = new Person();
        person.setAge(255);
        person.setAddress("rgreg");
        person.setName("lindec");
//        personRepository.deleteAll();
        personRepository.save(person);

//        System.out.println("------------------------------------");
//        System.out.println("--------" + env.getProperty("app.tcpPort"));

    }

    @Test
    public void postTest() {
        Map<String, String> map = new HashMap<>();
        map.put("Accept", "application/json");
        map.put("Content-Type", "application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        Map<String, String> mapMsg = new HashMap<>();
        mapMsg.put("username", "lindec");
//        mapMsg.put("password","0123");
        try {
            System.out.println("-------------------");
            System.out.println(HttpTool.httpConnect("http://localhost:8089/login", objectMapper.writeValueAsString(mapMsg), map, "POST").toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
