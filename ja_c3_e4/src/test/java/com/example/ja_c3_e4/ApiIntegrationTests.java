package com.example.ja_c3_e4;

import com.example.ja_c3_e4.repositories.DemoRepository;
import com.example.ja_c3_e4.services.exceptions.InexistentItemException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiIntegrationTests {

  @MockBean
  private DemoRepository demoRepository;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void test1() throws Exception {
    mockMvc.perform(get("/demo"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello!"));
  }

  @Test
  public void test2() throws Exception {
    List<String> list = List.of("A", "B", "C");
    String item = "D";

    given(demoRepository.list()).willReturn(list);  // assumption

    mockMvc.perform(post("/item/" + item))
        .andExpect(status().isOk());

    verify(demoRepository, times(1)).add(item);
  }

  @Test
  public void test3() throws Exception {
    List<String> list = List.of("A", "B", "C");
    String item = "C";

    given(demoRepository.list()).willReturn(list);

    mockMvc.perform(post("/item/" + item))
        .andExpect(status().isBadRequest());

    verify(demoRepository, never()).add(item);
  }

  @Test
  public void test4() throws Exception {
    List<String> list = List.of("A", "B", "C");
    String key = "abc";

    given(demoRepository.list()).willReturn(list);

    mockMvc.perform(get("/search/" + key))
            .andExpect(status().isOk())
            .andExpect(content().json("[]"));
  }

  @Test
  public void test5() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();

    List<String> list = List.of("A", "B", "C");
    List<String> expectedResult = List.of("B");
    String key = "B";

    given(demoRepository.list()).willReturn(list);

    mockMvc.perform(get("/search/" + key))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(expectedResult)));
  }
}
