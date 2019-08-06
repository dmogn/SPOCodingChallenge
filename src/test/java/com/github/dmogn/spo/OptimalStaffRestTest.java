package com.github.dmogn.spo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Endpoint integration tests.
 */
@SpringJUnitConfig(Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OptimalStaffRestTest {
    private static final String CALCULATE_STUFF_URI = "/api/v1/calculateStaffRequirements";
    
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void test() throws Exception {
        final String requestBody = "{ \"rooms\": [35, 21, 17, 28], \"senior\": 10, \"junior\": 6 }";
        
        final MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders
                        .post(CALCULATE_STUFF_URI)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        
        Assert.assertEquals(200, mvcResult.getResponse().getStatus());
    }
}
