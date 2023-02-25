package com.example.dockerTest.controller;

import com.example.dockerTest.User;
import com.example.dockerTest.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    UserRepository userRepository;

    @Test
    void returnContent() throws Exception {

        String RequestContest = "{\"content\" : \"hello\"}";

        mvc.perform(
                post("/return")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(RequestContest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", is("hello")))
                .andDo(print());
    }

    @Test
    void returnHello() throws Exception {
        mvc.perform(
                        get("/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("hello")))
                .andExpect(jsonPath("$.age", is(20)))
                .andDo(print());
    }

    @Test
    void returnHelloFail() throws Exception {
        mvc.perform(
                        get("/hello-fail"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void returnBye() throws Exception {
        mvc.perform(
                        get("/bye"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void repoTest() {
        userRepository.save(new User("aa", "aa", "aa", "aa"));

        List<User> all = userRepository.findAll();
        Assertions.assertEquals(all.size(), 1);
    }
}