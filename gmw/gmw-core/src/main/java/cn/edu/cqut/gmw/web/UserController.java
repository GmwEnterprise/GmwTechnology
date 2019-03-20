package cn.edu.cqut.gmw.web;

import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.service.UserService;
import cn.edu.cqut.gmw.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gmw
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public AjaxResult userMessage(@PathVariable("id") Long id) {
    User user = userService.get(id);
    if (user != null) {
      return AjaxResult.success()
          .set("user", user);
    }
    return AjaxResult.error("未找到相应用户实例");
  }

  @GetMapping("/list")
  public AjaxResult userMessage(User user) {
    List<User> list = userService.getList(user);
    if (list != null && list.size() > 0 ) {
      return AjaxResult.success()
          .set("list", list);
    }
    return AjaxResult.error();
  }

  @PostMapping("/modify")
  public AjaxResult modifyMessage(User user) {
    if (user == null || user.getId() == null) {
      return AjaxResult.error("请求参数错误！");
    }
    User now = new User();
    now.setUserName(user.getUserName());
    now.setPhoneNumber(user.getPhoneNumber());
    now.setEmail(user.getEmail());
    now.setSex(user.getSex());
    now.setPassword(user.getPassword());
    int modify = userService.modify(now);
    if (modify == 1) {
      return AjaxResult.success();
    }
    return AjaxResult.error("修改错误！");
  }

  @GetMapping("/login")
  public AjaxResult userLogin(User user) {
    // TODO
    return AjaxResult.error("登录失败");
  }
}
