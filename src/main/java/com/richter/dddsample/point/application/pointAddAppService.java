package com.richter.dddsample.point.application;

import com.richter.dddsample.customer.domain.CustomerEntity;
import com.richter.dddsample.customer.domain.ICustomerRepository;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import com.richter.dddsample.point.domain.IHoldingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class pointAddAppService {
    private final ICustomerRepository customerRepository;
    private final IHoldingPointRepository holdingPointRepository;

    @Autowired
    public pointAddAppService(ICustomerRepository customerRepository, IHoldingPointRepository holdingPointRepository) {
        this.customerRepository = customerRepository;
        this.holdingPointRepository = holdingPointRepository;
    }

    public HoldingPointEntity add(int customerId, int cost) {
        // 顧客情報を取得
        CustomerEntity customer = this.customerRepository.findById(customerId);
        // 既存保有ポイントを取得
        HoldingPointEntity holdingPoint = this.holdingPointRepository.findByCustomerId(customerId);

        // TODO: 保有ポイントを加算


        return new HoldingPointEntity(1, 112);
    }
}
