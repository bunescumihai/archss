package com.inventory.demo.service.producer;

import com.inventory.demo.entity.Owner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OwnerProducer {

    private static final String TOPIC = "CREATE_OWNER_TOPIC";
    private final KafkaTemplate<String, Owner> kafkaTemplate;

    public OwnerProducer(KafkaTemplate<String, Owner> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOwner(Owner owner) {
        kafkaTemplate.send(TOPIC, owner);
        System.out.println("📦 Sent Product to Kafka: " + owner.getName());
    }
}
