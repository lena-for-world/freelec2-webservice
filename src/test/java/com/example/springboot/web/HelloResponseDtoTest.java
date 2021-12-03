package com.example.springboot.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;
import org.assertj.core.api.Assertions;
import org.example.springboot.Application;
import org.example.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = Application.class)
public class HelloResponseDtoTest {

    @Autowired private MockMvc mockMvc;

    @Test
    public void 롬복_기능_테스트() throws Exception {
        String name = "test";
        int amount = 1000;

        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);
        Assertions.assertThat(helloResponseDto.getName()).isEqualTo(name);
        Assertions.assertThat(helloResponseDto.getAmount()).isEqualTo(amount);
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {

        String name = "이름";
        int amount = 1000;

        mockMvc.perform(
            get("/hello/dto")
            .param("name", name)
            .param("amount", String.valueOf(amount))
        ).andExpect(status().isOk())
            .andExpect(jsonPath("$.name", is(name)))
            .andExpect(jsonPath("$.amount", is(amount)));
    }

}
