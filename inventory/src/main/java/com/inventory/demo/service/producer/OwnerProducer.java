package com.inventory.demo.service.producer;

import com.inventory.demo.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OwnerProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic;

    public OwnerProducer(KafkaTemplate<String, Object> kafkaTemplate,
                         @Value("${app.topic.create-owner-topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(Owner owner) {
        kafkaTemplate.send(topic, owner.getId().toString(), owner);
        System.out.println("Sent Order to " + topic + " -> " + owner);
    }
}
