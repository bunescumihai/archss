package com.demand.demo.service.impl.ed;

import com.inventory.demo.entity.Owner;
import com.demand.demo.mediator.RepositoryMediator;
import com.demand.demo.service.OwnerGetter;

public class OwnerGetterEdImpl implements OwnerGetter {
    private final RepositoryMediator repositoryMediator;

    public OwnerGetterEdImpl(RepositoryMediator repositoryMediator) {
        this.repositoryMediator = repositoryMediator;
    }

    @Override
    public Owner getOwnerById(Long id) {
        return repositoryMediator.getOwnerRepository().findById(id).orElse(null);
    }
}
