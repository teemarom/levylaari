package hh.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    // index
    @GetMapping
    public String index() {
        return "index"; // index.html
    }

    // log in
    @RequestMapping(value="/login")
    public String login() {
        return "login"; // login.html
    }
    
    // album list
    @GetMapping("/albumlist")
    public String albumList() {
        return "albumlist";
    }
}
