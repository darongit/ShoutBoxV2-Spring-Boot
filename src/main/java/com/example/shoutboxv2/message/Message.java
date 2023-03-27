package com.example.shoutboxv2.message;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @SequenceGenerator(name = "message_sequence", sequenceName = "message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
    private Long id;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String author;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private LocalDateTime timeOfPublished = LocalDateTime.now();

    public Message(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getTimeSincePublished() {
        Long diff;

        diff = ChronoUnit.YEARS.between(timeOfPublished, LocalDateTime.now());
        if (diff >= 1) {
            if (diff == 1) {
                return String.format("%s year", diff);
            }
            return String.format("%s years", diff);
        }

        diff = ChronoUnit.MONTHS.between(timeOfPublished, LocalDateTime.now());
        if (diff >= 1) {
            if (diff == 1) {
                return String.format("%s month", diff);
            }
            return String.format("%s month", diff);
        }

        diff = ChronoUnit.DAYS.between(timeOfPublished, LocalDateTime.now());
        if (diff >= 1) {
            if (diff == 1) {
                return String.format("%s day", diff);
            }
            return String.format("%s days", diff);
        }

        diff = ChronoUnit.HOURS.between(timeOfPublished, LocalDateTime.now());
        if (diff >= 1) {
            if (diff == 1) {
                return String.format("%s hour", diff);
            }
            return String.format("%s hours", diff);
        }

        diff = ChronoUnit.MINUTES.between(timeOfPublished, LocalDateTime.now());
        if (diff >= 1) {
            if (diff == 1) {
                return String.format("%s minute", diff);
            }
            return String.format("%s minutes", diff);
        }

        diff = ChronoUnit.SECONDS.between(timeOfPublished, LocalDateTime.now());
        if (diff == 1) {
            return String.format("%s second", diff);
        }
        return String.format("%s seconds", diff);
    }
}
