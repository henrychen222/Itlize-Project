package manage.backendjava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Api {

  @GetMapping("/test")
  String get() {
    return "You can see me if you got token!";
  }

}
