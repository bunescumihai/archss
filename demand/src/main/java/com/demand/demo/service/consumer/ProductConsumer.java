package com.demand.demo.service.consumer;

import com.inventory.demo.entity.Product; // Assuming you have a Product class
import com.demand.demo.mediator.RepositoryMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductConsumer {

    @Autowired
    private RepositoryMediator repositoryMediator;
    @KafkaListener(topics = "${app.topic.create-product-topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void listen(Product product) {
        System.out.println("Received Product: " + product.toString());
        repositoryMediator.getProductRepository().save(product);
    }
}