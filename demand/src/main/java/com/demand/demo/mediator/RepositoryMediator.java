package com.demand.demo.mediator;

import com.demand.demo.repository.BuyerRepository;
import com.demand.demo.repository.DemandRepository;
import com.demand.demo.repository.OwnerRepository;
import com.demand.demo.repository.ProductRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Service
public class RepositoryMediator {
    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private DemandRepository demandRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OwnerRepository ownerRepository;

}
