package com.demand.demo.config;

import com.demand.demo.mediator.RepositoryMediator;
import com.demand.demo.service.DemandService;
import com.demand.demo.service.impl.DemandServiceImpl;
import com.demand.demo.service.impl.ed.OwnerGetterEdImpl;
import com.demand.demo.service.impl.ed.ProductGetterEdImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    private RepositoryMediator repositoryMediator;

    @Bean
    public DemandService demandService() {
        return new DemandServiceImpl(
                new OwnerGetterEdImpl(repositoryMediator),
                new ProductGetterEdImpl(repositoryMediator),
                repositoryMediator
        );
    }
}
