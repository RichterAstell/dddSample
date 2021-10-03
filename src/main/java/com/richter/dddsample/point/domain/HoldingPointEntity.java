package com.richter.dddsample.point.domain;

public class HoldingPointEntity {
    private String customerId;
    private Integer holdingPoint;

    public HoldingPointEntity(String customerId, Integer holdingPoint) {
        this.customerId = customerId;
        this.holdingPoint = holdingPoint;
    }

    public void addHoldingPoint(Integer addPoint) {
        this.holdingPoint += addPoint;
    }

    public String getCustomerId() {
        return customerId;
    }
    public Integer getHoldingPoint() {
        return holdingPoint;
    }
}
