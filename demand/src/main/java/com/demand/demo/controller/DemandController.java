package com.demand.demo.controller;

import com.demand.demo.dto.CreateDemandDto;
import com.demand.demo.dto.GetDemandDto;
import com.demand.demo.entity.Demand;
import com.demand.demo.service.DemandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demands")
public class DemandController {

    private final DemandService demandService;

    public DemandController(DemandService demandService) {
        this.demandService = demandService;
    }

    @PostMapping
    public Demand createDemand(@RequestBody CreateDemandDto createDemandDto) {
        return demandService.create(createDemandDto);
    }

    @GetMapping
    public List<GetDemandDto> getAllDemands() {
        return demandService.getAll();
    }

    @GetMapping("/{id}")
    public GetDemandDto getById(@PathVariable Long id) {
        return demandService.getDemandById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteDemand(@PathVariable Long id) {
        return demandService.deleteDemandById(id);
    }
}
