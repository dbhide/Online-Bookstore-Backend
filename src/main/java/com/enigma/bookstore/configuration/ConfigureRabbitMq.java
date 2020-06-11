package com.enigma.bookstore.configuration;


import com.enigma.bookstore.rabbitmq.consumer.NotificationHandler;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureRabbitMq {

    public static final String EXCHANGE_NAME = "subscription";
    public static final String QUEUE_NAME = "subscribers";

    @Bean
    Queue createQueue() {
        return new Queue(QUEUE_NAME, true, false, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue q, TopicExchange exchange) {
        return BindingBuilder.bind(q).to(exchange).with("enigma.#");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

