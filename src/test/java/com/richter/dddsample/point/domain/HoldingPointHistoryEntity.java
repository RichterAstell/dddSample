package com.richter.dddsample.point.domain;


public class HoldingPointHistoryEntity {
    private final Integer customerId;
    private final Integer holdingPoint;
    private final UseType useType;

    public HoldingPointHistoryEntity(Integer customerId, Integer holdingPoint, UseType useType) {
        this.customerId = customerId;
        this.holdingPoint = holdingPoint;
        this.useType = useType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getHoldingPoint() {
        return holdingPoint;
    }

    public UseType getUseType() {
        return useType;
    }
}
