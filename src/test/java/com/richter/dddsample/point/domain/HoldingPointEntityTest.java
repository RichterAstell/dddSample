package com.richter.dddsample.point.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HoldingPointEntityTest {
    @Test
    public void 顧客IDのテスト() {
        HoldingPointEntity entity = new HoldingPointEntity(1, 100);
        Assertions.assertEquals(1, entity.getCustomerId());
    }
    @Test
    public void 保有ポイント作成のテスト() {
        HoldingPointEntity entity = new HoldingPointEntity(1, 100);
        Assertions.assertEquals(100, entity.getHoldingPoint());
    }
    @Test
    public void 保有ポイントから保有ポイント加算のテスト() {
        HoldingPointEntity entity = new HoldingPointEntity(1, 100);
        entity.addHoldingPoint(10);
        Assertions.assertEquals(110, entity.getHoldingPoint());
    }
    @Test
    public void 買い物金額から保有ポイント加算のテスト() {
        HoldingPointEntity entity = new HoldingPointEntity(1, 100);
        entity.addHoldingPointByCost(1980);
        Assertions.assertEquals(119, entity.getHoldingPoint());
    }
}
