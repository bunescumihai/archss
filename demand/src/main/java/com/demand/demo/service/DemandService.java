package com.demand.demo.service;

import com.demand.demo.dto.CreateDemandDto;
import com.demand.demo.dto.GetDemandDto;
import com.demand.demo.entity.Demand;

import java.util.List;

public interface DemandService {
    Demand create(CreateDemandDto createDemandDto);
    GetDemandDto getDemandById(Long id);
    List<GetDemandDto> getAll();
    boolean deleteDemandById(Long id);
}
