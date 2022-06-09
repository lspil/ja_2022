package com.example.ja_c3_e4.repositories;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DemoRepository {

  private final List<String> list = new ArrayList<>();

  public void add(String item) {
    list.add(item);
  }

  public List<String> list() {
    return list;
  }
}
