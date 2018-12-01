package com.baeldung;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class DataLoaderLiveTest {

    @Test
    public void exampleTest() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("http://localhost:8090/startNotification/10", String.class);
    }

}
