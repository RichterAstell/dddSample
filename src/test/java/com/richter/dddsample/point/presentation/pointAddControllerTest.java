package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.application.pointAddAppService;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;

import org.mockito.Mockito;

public class pointAddControllerTest {
    @Test
    public void ポイント付与のテスト() {
        HoldingPointEntity holdingPoint = new HoldingPointEntity(1, 112);
        // service mock の作成
        pointAddAppService service = Mockito.mock(pointAddAppService.class);
        Mockito.when(service.add(anyInt(), anyInt()))
                .thenReturn(holdingPoint);
        // controller の作成
        pointAddController controller = new pointAddController(service);
        // 実行
        HoldingPointEntity response = controller.add(1, 1234);
        Assertions.assertEquals(112, response.getHoldingPoint());
    }
}
