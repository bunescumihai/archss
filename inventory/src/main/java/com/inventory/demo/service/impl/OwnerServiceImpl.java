package com.inventory.demo.service.impl;

import com.inventory.demo.dto.owner.OwnerCreateDto;
import com.inventory.demo.entity.Owner;
import com.inventory.demo.mediator.MapperMediator;
import com.inventory.demo.mediator.RepositoryMediator;
import com.inventory.demo.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private RepositoryMediator repositoryMediator;

    @Autowired
    private MapperMediator mapperMediator;

    public List<Owner> findAll() {
        return repositoryMediator.getOwnerRepository().findAll();
    }

    public Owner findById(Long id) {
        return repositoryMediator.getOwnerRepository().findById(id).orElse(null);
    }

    @Transactional
    public Owner save(OwnerCreateDto ownerCreateDto) {
        Owner owner = mapperMediator.getOwnerMapper().toEntity(ownerCreateDto);
        return repositoryMediator.getOwnerRepository().save(owner);
    }

    public Owner update(Long id, Owner updated) {
        updated.setId(id);
        return repositoryMediator.getOwnerRepository().save(updated);
    }

    public void delete(Long id) {
        repositoryMediator.getOwnerRepository().deleteById(id);
    }
}

