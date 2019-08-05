package com.github.dmogn.spo;

import com.github.dmogn.spo.model.OptimalStaffRequest;
import com.github.dmogn.spo.model.OptimalStaffResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.client.RestTemplate;

/**
 * Endpoint integration tests.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringJUnitConfig(TestConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OptimalStaffRestTest {
    @Value("${local.server.port}")
    protected int port;
    
    @Test
    public void test() {
        final OptimalStaffRequest requestBody = new OptimalStaffRequest(
                new int[]{24, 28},
                11,
                6
        );
        
        final HttpEntity<OptimalStaffRequest> request = new HttpEntity<>(requestBody);
        final RestTemplate restTemplate = new RestTemplate();
        
        final ResponseEntity<OptimalStaffResponse> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/calculateStaffRequirements", 
                HttpMethod.POST, 
                request, 
                OptimalStaffResponse.class);
        
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
