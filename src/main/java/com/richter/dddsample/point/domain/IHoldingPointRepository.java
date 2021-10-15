package com.richter.dddsample.point.domain;

public interface IHoldingPointRepository {
    Integer save(HoldingPointEntity holdingPoint);

    HoldingPointEntity findByCustomerId(int customerId);
}
