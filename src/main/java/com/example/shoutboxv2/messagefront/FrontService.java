package com.example.shoutboxv2.messagefront;

import com.example.shoutboxv2.message.Message;
import com.example.shoutboxv2.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class FrontService {
    private MessageService messageService;
    @Autowired
    public FrontService(MessageService messageService) {
        this.messageService = messageService;
    }

    public String mainPage(Model model) {
        return mainPage(model, "");
    }

    public String mainPage(Model model, String author) {
        model.addAttribute("author", author);
        model.addAttribute("messages", messageService.getAllMessages());
        return "main";
    }

    public void addMessage(Message message) {
        messageService.addMessage(message);
    }
}
