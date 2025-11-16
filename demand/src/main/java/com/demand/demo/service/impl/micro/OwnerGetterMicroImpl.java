package com.demand.demo.service.impl.micro;

import com.demand.demo.entity.Owner;
import com.demand.demo.service.OwnerGetter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestClient;

public class OwnerGetterMicroImpl implements OwnerGetter {

    private final RestClient restClient;

    public OwnerGetterMicroImpl(@Qualifier("inventoryService") RestClient restClient) {
        this.restClient = restClient;
    }

    public Owner getOwnerById(Long id) {
        return restClient.get()
                .uri("api/owners/{id}", id)
                .retrieve()
                .body(Owner.class);
    }
}
