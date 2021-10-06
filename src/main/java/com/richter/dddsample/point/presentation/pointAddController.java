package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.application.pointAddAppService;
import com.richter.dddsample.point.domain.HoldingPointEntity;

public class pointAddController {
    public HoldingPointEntity add(int customerId, int cost) {
        pointAddAppService appService = new pointAddAppService();
        return appService.add(customerId, cost);
    }
}
