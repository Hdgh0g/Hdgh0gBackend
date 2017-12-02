package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.config.PropertiesConfig;
import com.hdgh0g.backend.config.SecurityConfig;
import com.hdgh0g.backend.config.jackson.JacksonConfig;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.services.AdminService;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.jayway.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.test.web.servlet.MockMvc;

@TestConfiguration
@Import({
        JacksonConfig.class,
        SecurityConfig.class,
        PropertiesConfig.class
})
public class TestMvcConfiguration {

    @Bean
    public AdminService adminManager() {
        return password -> {
        };
    }

    @Bean
    @Scope("prototype")
    protected MockMvcRequestSpecification given(MockMvc mockMvc) {
        return RestAssuredMockMvc.given().mockMvc(mockMvc);
    }
}
