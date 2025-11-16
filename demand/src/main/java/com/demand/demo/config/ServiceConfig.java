package com.demand.demo.config;

import com.demand.demo.mediator.RepositoryMediator;
import com.demand.demo.service.DemandService;
import com.demand.demo.service.impl.DemandServiceImpl;
import com.demand.demo.service.impl.micro.OwnerGetterMicroImpl;
import com.demand.demo.service.impl.micro.ProductGetterMicroImpl;
import com.demand.demo.service.impl.ed.OwnerGetterEdImpl;
import com.demand.demo.service.impl.ed.ProductGetterEdImpl;
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
                    new OwnerGetterMicroImpl(restClientInventoryService),
                    new ProductGetterMicroImpl(restClientInventoryService),
                    repositoryMediator
            );
        } else {
            return new DemandServiceImpl(
                    new OwnerGetterEdImpl(repositoryMediator),
                    new ProductGetterEdImpl(repositoryMediator),
                    repositoryMediator
            );
        }
    }
}
