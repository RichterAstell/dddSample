package com.richter.dddsample.point.application;

import com.richter.dddsample.point.domain.HoldingPointEntity;
import com.richter.dddsample.point.domain.IHoldingPointRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PointUseAppServiceTest {

    @Test
    public void ポイント利用のテスト() {
        IHoldingPointRepository repository = Mockito.mock(IHoldingPointRepository.class);
        PointUseAppService service = new PointUseAppService(repository);
        HoldingPointEntity result = service.use(1, 10);
        Assertions.assertEquals(90, result.getHoldingPoint());
    }
}