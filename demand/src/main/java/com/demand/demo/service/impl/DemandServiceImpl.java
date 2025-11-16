package com.demand.demo.service.impl;

import com.demand.demo.dto.CreateDemandDto;
import com.demand.demo.dto.GetDemandDto;
import com.inventory.demo.entity.Owner;
import com.inventory.demo.entity.Product;
import com.demand.demo.entity.BuyerProfile;
import com.demand.demo.entity.Demand;
import com.demand.demo.mediator.RepositoryMediator;
import com.demand.demo.service.DemandService;
import com.demand.demo.service.OwnerGetter;
import com.demand.demo.service.ProductGetter;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class DemandServiceImpl implements DemandService {

    private final OwnerGetter ownerGetter;
    private final ProductGetter productGetter;
    private final RepositoryMediator repositoryMediator;

    public DemandServiceImpl(OwnerGetter ownerGetter, ProductGetter productGetter, RepositoryMediator repositoryMediator) {
        this.ownerGetter = ownerGetter;
        this.productGetter = productGetter;
        this.repositoryMediator = repositoryMediator;
    }

    @Transactional
    @Override
    public Demand create(CreateDemandDto createDemandDto) {
        Owner owner = ownerGetter.getOwnerById(createDemandDto.getOwnerId());
        if (owner == null) {
            throw new IllegalArgumentException("Owner not found with id: " + createDemandDto.getOwnerId());
        }

        Product product = productGetter.getProductById(createDemandDto.getProductId());
        if (product == null) {
            throw new IllegalArgumentException("Product not found with id: " + createDemandDto.getProductId());
        }

        BuyerProfile buyerProfile = new BuyerProfile();
        buyerProfile.setOwnerId(createDemandDto.getOwnerId());
        buyerProfile.setName(createDemandDto.getBuyerProfileDto().getName());
        buyerProfile.setContactInfo(createDemandDto.getBuyerProfileDto().getContactInfo());
        buyerProfile.setRegion(createDemandDto.getBuyerProfileDto().getRegion());
        buyerProfile = repositoryMediator.getBuyerRepository().save(buyerProfile);

        System.out.println("Creating demand for product: " + product.getName() + " by owner: " + owner.getName());
        System.out.println("Buyer Profile ID: " + buyerProfile.getId());

        Demand demand = new Demand();
        demand.setQuantity(createDemandDto.getQuantity());
        demand.setProductId(product.getId());
        demand.setStatus("CREATED");
        demand.setValidUntil(createDemandDto.getValidUntil());
        demand.setTitle(createDemandDto.getTitle());
        demand.setBuyerProfile(buyerProfile);

        return repositoryMediator.getDemandRepository().save(demand);
    }

    @Override
    public GetDemandDto getDemandById(Long id) {
        System.out.println("Fetching demand with id: " + id);
        Demand demand = repositoryMediator.getDemandRepository().findById(id).orElse(null);
        if (demand == null) {
            return null;
        }

        BuyerProfile buyerProfile = repositoryMediator.getBuyerRepository().findById(demand.getBuyerProfileId()).orElse(null);
        if (buyerProfile == null) {
            return null;
        }

        GetDemandDto getDemandDto = new GetDemandDto();
        getDemandDto.setId(demand.getId());
        getDemandDto.setTitle(demand.getTitle());
        getDemandDto.setQuantity(demand.getQuantity());
        getDemandDto.setProduct(productGetter.getProductById(demand.getProductId()));
        getDemandDto.setStatus(demand.getStatus());
        getDemandDto.setValidUntil(demand.getValidUntil());
        getDemandDto.setBuyerProfile(buyerProfile);
        getDemandDto.setBuyerData(ownerGetter.getOwnerById(buyerProfile.getOwnerId()));

        return getDemandDto;
    }

    @Override
    public List<GetDemandDto> getAll() {
        System.out.println("Fetching all demands");
        List<Demand> demands = repositoryMediator.getDemandRepository().findAll();
        List<GetDemandDto> result = new ArrayList<>();

        for (Demand demand : demands) {
            BuyerProfile buyerProfile = repositoryMediator.getBuyerRepository().findById(demand.getBuyerProfileId()).orElse(null);
            if (buyerProfile == null) {
                System.out.println("Skipping demand " + demand.getId() + " because buyer profile not found");
                continue;
            }

            Product product = productGetter.getProductById(demand.getProductId());
            if (product == null) {
                System.out.println("Skipping demand " + demand.getId() + " because product not found");
                continue;
            }

            Owner owner = ownerGetter.getOwnerById(buyerProfile.getOwnerId());
            if (owner == null) {
                System.out.println("Skipping demand " + demand.getId() + " because owner not found");
                continue;
            }

            GetDemandDto dto = new GetDemandDto();
            dto.setId(demand.getId());
            dto.setTitle(demand.getTitle());
            dto.setQuantity(demand.getQuantity());
            dto.setProduct(product);
            dto.setStatus(demand.getStatus());
            dto.setValidUntil(demand.getValidUntil());
            dto.setBuyerProfile(buyerProfile);
            dto.setBuyerData(owner);

            result.add(dto);
        }

        return result;
    }

    @Override
    public boolean deleteDemandById(Long id) {
        return repositoryMediator.getDemandRepository().findById(id).map(demand -> {
            repositoryMediator.getDemandRepository().delete(demand);
            return true;
        }).orElse(false);
    }
}
