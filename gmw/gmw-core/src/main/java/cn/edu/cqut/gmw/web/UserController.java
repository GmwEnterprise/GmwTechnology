package cn.edu.cqut.gmw.web;

import cn.edu.cqut.gmw.dto.UserMessageDto;
import cn.edu.cqut.gmw.dto.execution.UserExecution;
import cn.edu.cqut.gmw.enums.status.LoginStatus;
import cn.edu.cqut.gmw.enums.status.RegisterStatus;
import cn.edu.cqut.gmw.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gmw
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public UserExecution<LoginStatus> userLogin(UserMessageDto userMessage) {
    return userService.validUser(userMessage);
  }

  public UserExecution<RegisterStatus> register(UserMessageDto userMessage) {
    return null;

  }
}
