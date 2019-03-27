package cn.edu.cqut.gmw.web;

import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.enums.UserStatusEnum;
import cn.edu.cqut.gmw.redis.RedisUtils;
import cn.edu.cqut.gmw.service.UserService;
import cn.edu.cqut.gmw.util.AjaxResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Gmw
 */
@RestController
@RequestMapping("/system/user")
public class UserController {

  private final UserService userService;
  private final RedisUtils redis;

  public UserController(
      UserService userService,
      RedisUtils redis) {
    this.userService = userService;
    this.redis = redis;
  }

  @GetMapping("/{id}")
  public AjaxResult userMessage(@PathVariable("id") Long id) {
    User val = userService.get(id);
    if (val != null && val.getId() != null) {
      return AjaxResult.success().set("user", val);
    }
    return AjaxResult.error();
  }

  @GetMapping("/list")
  public AjaxResult userList(User user) {
    return AjaxResult.success().set("list", userService.getList(user));
  }

  @PostMapping("/save")
  public AjaxResult save(User user) {
    User now;
    if (user.getId() == null) {
      now = userService.add(user);
    } else {
      now = userService.modify(user);
    }
    return AjaxResult.success().set("user", now);
  }

  @GetMapping("/login")
  public AjaxResult userLogin(User user) {
    User usr = new User();
    usr.setPhoneNumber(user.getPhoneNumber());
    List<User> result = userService
        .getList(usr)
        .stream()
        .filter(item -> item.getUserStatus().equals(UserStatusEnum.NORMAL))
        .collect(Collectors.toList());
    if (result.size() == 1) {
      User resultUser = result.get(0);
      if (resultUser.getPassword().equals(user.getPassword())) {
        String val = UUID.randomUUID().toString().replaceAll("-", "");
        redis.set(val, resultUser, 10L);
        return AjaxResult.success()
            .set("currentUser", resultUser)
            .set("token", val);
      }
    }
    return AjaxResult.error();
  }
}
