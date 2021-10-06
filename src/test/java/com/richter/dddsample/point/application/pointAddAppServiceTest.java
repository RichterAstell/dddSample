package com.richter.dddsample.point.application;

import com.richter.dddsample.point.application.pointAddAppService;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class pointAddAppServiceTest {
    @Test
    public void ポイント加算のテスト() {
        pointAddAppService appService = new pointAddAppService();
        HoldingPointEntity result = appService.add(1,1234);
        Assertions.assertEquals(12, result.getHoldingPoint());
    }
}
