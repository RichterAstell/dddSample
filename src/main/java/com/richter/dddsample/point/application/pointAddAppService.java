package com.richter.dddsample.point.application;

import com.richter.dddsample.customer.domain.CustomerEntity;
import com.richter.dddsample.customer.domain.ICustomerRepository;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class pointAddAppService {
    private static Integer POINT_RETE = 100;
    private final ICustomerRepository customerRepository;

    @Autowired
    public pointAddAppService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public HoldingPointEntity add(int customerId, int cost) {
        // 顧客情報を取得
        CustomerEntity customer = this.customerRepository.findById(customerId);
        return new HoldingPointEntity(1, 112);
    }
}
