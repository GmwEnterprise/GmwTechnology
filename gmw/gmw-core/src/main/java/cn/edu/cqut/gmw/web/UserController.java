package cn.edu.cqut.gmw.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 90949
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

  @GetMapping("/helloworld")
  public String helloWorld() {
    return "Hello Gmw !";
  }
}
