package com.richter.dddsample.point.domain;

public interface IHoldingPointRepository {
    public HoldingPointEntity save(HoldingPointEntity holdingPoint);

    HoldingPointEntity findByCustomerId(int customerId);
}
