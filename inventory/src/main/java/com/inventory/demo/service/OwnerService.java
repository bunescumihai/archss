package com.inventory.demo.service;

import com.inventory.demo.dto.owner.OwnerCreateDto;
import com.inventory.demo.entity.Owner;

import java.util.List;

public interface OwnerService {
    List<Owner> findAll();
    Owner findById(Long id);
    Owner save(OwnerCreateDto ownerCreateDto);
    Owner update(Long id, Owner updated);
    void delete(Long id);
}

