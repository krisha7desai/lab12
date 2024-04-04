package com.example.lab11;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingControllerTest {

    @LocalServerPort
   private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDoubledValue() {
        // Arrange
        int numberToDouble = 5;
        String url = "http://localhost:" + port + "/double?number=" + numberToDouble;

        // Act
        Integer result = restTemplate.getForObject(url, Integer.class);

        // Assert
        assertThat(result).isEqualTo(10);
    }
}
