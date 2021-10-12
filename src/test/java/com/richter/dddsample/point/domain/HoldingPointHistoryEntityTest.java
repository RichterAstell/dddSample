package com.richter.dddsample.point.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HoldingPointHistoryEntityTest {
    @Test
    public void 保有ポイント履歴作成のテスト() {
        HoldingPointHistoryEntity entity = new HoldingPointHistoryEntity(1, 100, UseType.Add);
        Assertions.assertEquals(1, entity.getCustomerId());
        Assertions.assertEquals(100, entity.getHoldingPoint());
        Assertions.assertEquals(UseType.Add, entity.getUseType());
    }
}
