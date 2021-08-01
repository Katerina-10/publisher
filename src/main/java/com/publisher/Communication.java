package com.publisher;

import com.publisher.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;


@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/subscriber/api/messages";


    public Boolean saveMess(Message message) throws IOException // отправка сообщения post запросом
    {
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, message, String.class);
            return true;
        }
        catch (ResourceAccessException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
    }
}
