package com.demand.demo.config;

import com.demand.demo.mediator.RepositoryMediator;
import com.demand.demo.service.DemandService;
import com.demand.demo.service.impl.DemandServiceImpl;
import com.demand.demo.service.impl.micro.OwnerGetterImpl;
import com.demand.demo.service.impl.micro.ProductGetterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ServiceConfig {

    @Value("${architecture}")
    private String architecture;

    @Autowired
    @Qualifier("inventoryService")
    private RestClient restClientInventoryService;

    @Autowired
    private RepositoryMediator repositoryMediator;

    @Bean
    public DemandService demandService() {
        if(architecture.equals("micro")) {
            return new DemandServiceImpl(
                    new OwnerGetterImpl(restClientInventoryService),
                    new ProductGetterImpl(restClientInventoryService),
                    repositoryMediator
            );
        } else {
            return new DemandServiceImpl(
                    null,
                    null,
                    repositoryMediator
            );
        }
    }
}
