package com.example.shoutboxv2.messagefront;

import com.example.shoutboxv2.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontController {
    private FrontService frontService;
    @Autowired
    public FrontController(FrontService frontService) {
        this.frontService = frontService;
    }

    @GetMapping("/")
    public String mainPage(Model model, @RequestParam(name = "author", defaultValue = "") String author) {
        return frontService.mainPage(model, author);
    }

    @PostMapping("/")
    public String addMessage(Model model, @RequestBody Message message) {
        frontService.addMessage(message);
        return frontService.mainPage(model);
    }
}
