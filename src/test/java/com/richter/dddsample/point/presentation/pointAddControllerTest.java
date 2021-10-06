package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class pointAddControllerTest {
    @Test
    public void ポイント付与のテスト() {
        pointAddController controller = new pointAddController();
        HoldingPointEntity response = controller.add(1, 1234);
        Assertions.assertEquals(12, response.getHoldingPoint());
    }
}
