package com.example.ja_c3_e4;

import com.example.ja_c3_e4.repositories.DemoRepository;
import com.example.ja_c3_e4.services.DemoService;
import com.example.ja_c3_e4.services.exceptions.InexistentItemException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
class UnitTests {

  @Test
  @DisplayName("""
      Test what happens when calling the add method for an item that doesn't exist.
      We expect the item is added to the list.
      """)
  void test1() {
    DemoRepository demoRepository = mock(DemoRepository.class);
    DemoService demoService = new DemoService(demoRepository);

    List<String> list = List.of("A", "B", "C");
    String item = "D";

    given(demoRepository.list()).willReturn(list);  // assumption

    demoService.add(item);   // test method call

    verify(demoRepository, times(1)).add(item); // validation
  }

  @Test
  @DisplayName("""
      Test what happens when calling the add method for an item that already exists.
      We expect the method throws InexistentItemException.
      """)
  void test2() {
    DemoRepository demoRepository = mock(DemoRepository.class);
    DemoService demoService = new DemoService(demoRepository);

    List<String> list = List.of("A", "B", "C");
    String item = "C";

    given(demoRepository.list()).willReturn(list);  // assumption

    assertThrows(InexistentItemException.class, () -> demoService.add(item));
    verify(demoRepository, never()).add(item);
  }

  @Test
  void test3() {
    DemoRepository demoRepository = mock(DemoRepository.class);
    DemoService demoService = new DemoService(demoRepository);

    List<String> list = List.of("A", "B", "C");
    String key = "abc";

    given(demoRepository.list()).willReturn(list);

    var result = demoService.search(key);

    assertTrue(result.isEmpty());
  }

  @Test
  void test4() {
    DemoRepository demoRepository = mock(DemoRepository.class);
    DemoService demoService = new DemoService(demoRepository);

    List<String> list = List.of("A", "B", "C");
    List<String> expectedResult = List.of("B");
    String key = "B";

    given(demoRepository.list()).willReturn(list);

    var result = demoService.search(key);

    assertEquals(expectedResult, result);
  }
}
