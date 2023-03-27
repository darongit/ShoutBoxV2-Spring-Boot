package com.example.shoutboxv2.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public List<Message> getAllMessages() {
        return messageRepository.findAll().stream()
                .sorted((message1, message2) -> message2.getTimeOfPublished().compareTo(message1.getTimeOfPublished()))
                .toList();
    }
    public Message putMessage(Message message, Long messageId) {
        message.setId(messageId);
        return messageRepository.save(message);
    }

    public Message addMessage(Message message) {
        if (message.getContent().strip().equals("") || message.getAuthor().strip().equals("")) {
            return message;
        }
        int secondsLimit = 10;
        for (Message existMessage: messageRepository.findAll().stream()
                .filter(message1 -> message1.getAuthor().equals(message.getAuthor()))
                .filter((message1 -> message1.getContent().equals(message.getContent()))).toList()) {
            if (ChronoUnit.SECONDS.between(existMessage.getTimeOfPublished(), message.getTimeOfPublished()) < secondsLimit) {
                return message;
            }
        }
        return messageRepository.save(message);
    }

    public Message deleteMessage(Long id) {
        Optional<Message> tmp= messageRepository.findById(id);
        messageRepository.deleteById(id);
        return tmp.orElse(new Message("Error", "ID not found"));
    }
}
