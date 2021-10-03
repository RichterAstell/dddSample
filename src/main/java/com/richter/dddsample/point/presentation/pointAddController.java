package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.application.pointAddAppService;

public class pointAddController {
    public Integer add(int cost) {
        pointAddAppService appService = new pointAddAppService();
        return appService.add(cost);
    }
}
