package com.enigma.bookstore.rabbitmq.producer;

import com.enigma.bookstore.configuration.ConfigureRabbitMq;
import com.enigma.bookstore.dto.EmailTemplateDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void addToSubscriberQueue(EmailTemplateDTO emailTemplate) {
        rabbitTemplate.convertAndSend(ConfigureRabbitMq.EXCHANGE_NAME, "enigma.bookstore", emailTemplate);
    }
}
