package com.inventory.demo.service.producer;

import com.inventory.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic;

    public ProductProducer(KafkaTemplate<String, Object> kafkaTemplate,
                           @Value("${app.topic.create-product-topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(Product product) {
        kafkaTemplate.send(topic, product.getId().toString(), product);
        System.out.println("Sent Payment to " + topic + " -> " + product);
    }
}
