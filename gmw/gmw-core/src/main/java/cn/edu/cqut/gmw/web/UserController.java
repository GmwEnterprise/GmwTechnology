package cn.edu.cqut.gmw.web;

import cn.edu.cqut.gmw.common.util.MapResult;
import cn.edu.cqut.gmw.dto.LoginMessage;
import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.enums.UserExecStatus;
import cn.edu.cqut.gmw.service.UserService;
import cn.edu.cqut.gmw.vo.UserExecution;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  public MapResult login(LoginMessage message) {
    String phone = message.getPhone();
    String password = message.getPassword();
    UserExecution execution = userService.userLogin(phone, password);
    if (execution.getStatus().equals(UserExecStatus.SUCCESS)) {
      return MapResult.success(execution);
    }
    return MapResult.error(execution);
  }

  @PostMapping("/create")
  public MapResult create(User createUser) {
    UserExecution execution = userService.createUser(createUser);
    if (execution.getStatus().equals(UserExecStatus.SUCCESS)) {
      return MapResult.success(execution);
    }
    return MapResult.error(execution);
  }
}
