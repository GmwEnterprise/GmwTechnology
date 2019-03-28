package cn.edu.cqut.gmw.web.fortest;

import cn.edu.cqut.gmw.util.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gmw
 */
@RestController
public class HeroComponent {

  @GetMapping("/assets/config.json")
  public AjaxResult getConfig() {
    return AjaxResult.hashMap()
        .set("heroesUrl", "api/heroes")
        .set("textfile", "assets/textfile.ts");
  }
}
