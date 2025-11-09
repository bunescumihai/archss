package com.demand.demo.mediator;

import com.demand.demo.repository.BuyerRepository;
import com.demand.demo.repository.DemandRepository;
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


}
