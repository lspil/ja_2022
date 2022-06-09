package com.example.ja_c3_e4.services;

import com.example.ja_c3_e4.repositories.DemoRepository;
import com.example.ja_c3_e4.services.exceptions.InexistentItemException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DemoService {

  private final DemoRepository demoRepository;

  public void add(String item) {  // adauga un item doar daca acesta nu exista, sau arunca exceptie in caz contrar
    var list = demoRepository.list();
    if (!list.contains(item)) {
      demoRepository.add(item);
    } else {
      throw new InexistentItemException();
    }
  }

  public List<String> listAll() { // returneaza toate valorile
    return demoRepository.list();
  }

  public List<String> search(String key) { // returneaza valorile care contin o cheie data
    var list = demoRepository.list();

//    List<String> result = new ArrayList<>();
//
//    for (String i : list) {
//      if (i.contains(key)) {
//        result.add(i);
//      }
//    }

    return list.stream()
        .filter(e ->e.contains(key))
        .collect(Collectors.toList());
  }

}
