package com.richter.dddsample.pointpresentation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class pointAddControllerTest {
    @Test
    public void ポイント付与成功のテスト() {
        pointAddController controller = new pointAddController();
        Integer response = controller.add(1234);
        Assertions.assertEquals(12, response);
    }
}
