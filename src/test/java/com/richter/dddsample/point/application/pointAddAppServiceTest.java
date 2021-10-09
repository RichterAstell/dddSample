package com.richter.dddsample.point.application;

import com.richter.dddsample.customer.domain.ICustomerRepository;
import com.richter.dddsample.infrastructure.postgresql.CustomerRepository;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class pointAddAppServiceTest {
    @Test
    public void ポイント加算のテスト() {
        ICustomerRepository repository = Mockito.mock(ICustomerRepository.class);
        pointAddAppService appService = new pointAddAppService(repository);
        HoldingPointEntity result = appService.add(1,1234);
        Assertions.assertEquals(112, result.getHoldingPoint());
    }
}
