package com.inventory.demo.controller;

import com.inventory.demo.dto.owner.OwnerCreateDto;
import com.inventory.demo.entity.Owner;
import com.inventory.demo.mediator.ServiceMediator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private ServiceMediator serviceMediator;

    @GetMapping
    public List<Owner> getAll() {
        return serviceMediator.getOwnerService().findAll();
    }

    @GetMapping("/{id}")
    public Owner getById(@PathVariable Long id) {
        return serviceMediator.getOwnerService().findById(id);
    }

    @PostMapping
    public Owner create(@Valid @RequestBody OwnerCreateDto owner) {
        return serviceMediator.getOwnerService().save(owner);
    }

    @PutMapping("/{id}")
    public Owner update(@PathVariable Long id, @RequestBody Owner owner) {
        return serviceMediator.getOwnerService().update(id, owner);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceMediator.getOwnerService().delete(id);
    }
}

