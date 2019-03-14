package cn.edu.cqut.gmw.web;

import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.service.UserService;
import cn.edu.cqut.gmw.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author 90949
 */
@CrossOrigin
@RestController
@RequestMapping("/sys/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  /**
   * 通过主键获取用户实例
   *
   * @param id 主键
   * @return 结果
   */
  @GetMapping("/{id}")
  public AjaxResult helloWorld(@PathVariable("id") Long id) {
    User user = userService.get(id);
    if (user != null) {
      return AjaxResult.success()
          .set("user", user);
    }
    return AjaxResult.error("未找到相应用户实例");
  }

  @PostMapping("/save")
  public AjaxResult save(User user) {
    int effect;
    if (user.getId() != null) {
      effect = userService.modify(user);
    } else {
      effect = userService.add(user);
    }
    if (effect > 0) {
      return AjaxResult.success("保存实例成功");
    }
    return AjaxResult.error("保存失败");
  }
}
