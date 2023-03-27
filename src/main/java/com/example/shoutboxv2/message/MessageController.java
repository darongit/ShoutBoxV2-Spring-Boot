package com.example.shoutboxv2.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {
    private MessageService messageService;
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = {"/messages", "/messages/"})
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping(value = {"/messages/add/", "/messages/add"})
    public Message addMessageRequestBody(@RequestBody Message message) {
        return messageService.addMessage(message);
    }

    @DeleteMapping("/messages/delete/{messageId}")
    public Message deleteMessageRequestParams(@PathVariable Long id) {
        return messageService.deleteMessage(id);
    }

    @PutMapping(value = "/messages/put/{messageId}")
    public Message putMessage(@RequestBody Message message, @PathVariable Long messageId) {
        return messageService.putMessage(message, messageId);
    }
}
