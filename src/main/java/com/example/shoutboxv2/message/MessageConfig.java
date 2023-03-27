package com.example.shoutboxv2.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class MessageConfig implements CommandLineRunner {
    private MessageRepository messageRepository;
    @Autowired
    public MessageConfig(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Message tmp = new Message("Billy", "Hi");
        tmp.setTimeOfPublished(LocalDateTime.now().minusMinutes(1));
        messageRepository.save(tmp);

        tmp = new Message("Brandon", "Hello?");
        tmp.setTimeOfPublished(LocalDateTime.now().minusSeconds(30));
        messageRepository.save(tmp);

        tmp = new Message("Billy", "Can I ask you for a favor?");
        tmp.setTimeOfPublished(LocalDateTime.now().minusSeconds(10));
        messageRepository.save(tmp);

    }
}
