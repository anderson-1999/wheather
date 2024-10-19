package com.example.weather.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CidadeControllerTest {

    @Autowired
    private MockMvc mvc;

    /**@Test
    public void shouldGetTodasCidades() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/cidade")).andExpect(status().isOk());
                //.andExpect((ResultMatcher) jsonPath("$.totalElements", CoreMatchers.equalTo(0)));
    }**/

}
