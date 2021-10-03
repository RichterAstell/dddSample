package com.richter.dddsample.point.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HoldingPointEntityTest {
    @Test
    public void 顧客IDのテスト() {
        HoldingPointEntity entity = new HoldingPointEntity("001", 100);
        Assertions.assertEquals("001", entity.getCustomerId());
    }
    @Test
    public void 保有ポイントのテスト() {
        HoldingPointEntity entity = new HoldingPointEntity("001", 100);
        Assertions.assertEquals(100, entity.getHoldingPoint());
    }
    @Test
    public void 保有ポイント加算のテスト() {
        HoldingPointEntity entity = new HoldingPointEntity("001", 100);
        entity.addHoldingPoint(10);
        Assertions.assertEquals(110, entity.getHoldingPoint());
    }
}
