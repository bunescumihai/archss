package com.demand.demo.service.consumer;

import com.demand.demo.mediator.RepositoryMediator;
import com.inventory.demo.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OwnerConsumer {

    @Autowired
    private RepositoryMediator repositoryMediator;

    @KafkaListener(topics = "${app.topic.create-owner-topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void listen(Owner owner) {
        repositoryMediator.getOwnerRepository().save(owner);
    }
}