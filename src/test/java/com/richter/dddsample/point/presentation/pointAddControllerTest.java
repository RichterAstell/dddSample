package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.application.PointAddRequest;
import com.richter.dddsample.point.application.PointAddAppService;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;

import org.mockito.Mockito;
import org.springframework.ui.Model;

public class pointAddControllerTest {
    @Test
    public void ポイント付与のテスト() {
        PointAddRequest request = new PointAddRequest(1, 1234);
        HoldingPointEntity holdingPoint = new HoldingPointEntity(1, 112);
        // service mock の作成
        PointAddAppService service = Mockito.mock(PointAddAppService.class);
        Mockito.when(service.add(anyInt(), anyInt()))
                .thenReturn(holdingPoint);
        Model model = Mockito.mock(Model.class);
        // controller の作成
        pointAddController controller = new pointAddController(service);
        // 実行
        String response = controller.add(model, request);
        Assertions.assertEquals("point/add", response);
    }
}
