package com.richter.dddsample.pointpresentation;

import com.richter.dddsample.pointdomain.pointAddAppService;

public class pointAddController {
    public Integer add(int cost) {
        pointAddAppService appService = new pointAddAppService();
        return appService.add(cost);
    }
}
