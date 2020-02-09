package fun.codefarmer.securitybysql.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ @ClassName HelloController
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/8 18:07
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello security";
    }
    @GetMapping("/dba/hello")
    public String dba() {
        return "hello security dba";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello security admin";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello security user";
    }
}
