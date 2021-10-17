package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.application.pointAddAppService;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;

import org.mockito.Mockito;
import org.springframework.ui.Model;

public class pointAddControllerTest {
    @Test
    public void ポイント付与のテスト() {
        HoldingPointEntity holdingPoint = new HoldingPointEntity(1, 112);
        // service mock の作成
        pointAddAppService service = Mockito.mock(pointAddAppService.class);
        Mockito.when(service.add(anyInt(), anyInt()))
                .thenReturn(holdingPoint);
        Model model = Mockito.mock(Model.class);
        // controller の作成
        pointAddController controller = new pointAddController(service);
        // 実行
        String response = controller.add(model);
        Assertions.assertEquals("point/add", response);
    }
}
