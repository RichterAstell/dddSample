package com.richter.dddsample.point.application;

import com.richter.dddsample.point.application.pointAddAppService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class pointAddAppServiceTest {
    @Test
    public void ポイント付与のテスト() {
        pointAddAppService appService = new pointAddAppService();
        Integer result = appService.add(1234);
        Assertions.assertEquals(12, result);
    }
}
