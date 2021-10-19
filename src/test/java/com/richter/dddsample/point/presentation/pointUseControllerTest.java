package com.richter.dddsample.point.presentation;

import com.richter.dddsample.point.domain.PointUseRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

public class pointUseControllerTest {
    @Test
    public void ポイント使用のテスト() {
        PointUseRequest request = new PointUseRequest(1, 10);
        // service mock の作成
//        PointUseAppService service = Mockito.mock(PointUseAppService.class);
        Model model = Mockito.mock(Model.class);
        // controller の作成
        pointUseController controller = new pointUseController();
        // 実行
        String response = controller.use(model, request);
        Assertions.assertEquals("point/use", response);
    }
}
