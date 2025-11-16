package com.inventory.demo.service.producer;

import com.inventory.demo.entity.Product;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {

    private static final String TOPIC = "CREATE_PRODUCT_TOPIC";
    private final KafkaTemplate<String, Product> kafkaTemplate;

    public ProductProducer(KafkaTemplate<String, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProduct(Product product) {
        kafkaTemplate.send(TOPIC, product);
        System.out.println("📦 Sent Product to Kafka: " + product.getName());
    }
}
