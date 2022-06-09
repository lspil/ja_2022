package com.example.ja_c3_e4.controllers;

import com.example.ja_c3_e4.services.DemoService;
import com.example.ja_c3_e4.services.exceptions.InexistentItemException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@AllArgsConstructor
public class DemoController {

  private final DemoService demoService;

  @GetMapping("/demo")
  public String demo() {
    return "Hello!";
  }

  @PostMapping("/item/{item}")
  public void add(@PathVariable String item, HttpServletResponse response) {
    try {
      demoService.add(item);
    } catch (InexistentItemException e) {
      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  @GetMapping("/item")
  public List<String> list() {
    return demoService.listAll();
  }

  @GetMapping("/search/{key}")
  public List<String> search(@PathVariable String key) {
    return demoService.search(key);
  }
}
