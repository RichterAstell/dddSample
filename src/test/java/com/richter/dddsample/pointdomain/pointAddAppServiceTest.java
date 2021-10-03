package com.richter.dddsample.pointdomain;

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
