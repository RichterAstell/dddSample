package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.application.pointAddAppService;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class pointAddController {
    private final pointAddAppService service;

    @Autowired
    public pointAddController(pointAddAppService service) {
        this.service = service;
    }

    public HoldingPointEntity add(int customerId, int cost) {
        return this.service.add(customerId, cost);
    }
}
