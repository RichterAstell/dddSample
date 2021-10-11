package com.richter.dddsample.point.domain;

public class HoldingPointEntity {
    private static Integer RATE = 100;
    private final Integer customerId;
    private Integer holdingPoint;

    public HoldingPointEntity(Integer customerId, Integer holdingPoint) {
        if (customerId == null || customerId == 0) {
            throw new IllegalArgumentException("customerId is require");
        }
        this.customerId = customerId;
        if (holdingPoint == null || holdingPoint <= 0) {
            throw new IllegalArgumentException("holdingPoint is require");
        }
        this.holdingPoint = holdingPoint;
    }

    public void addHoldingPoint(Integer addPoint) {
        this.holdingPoint += addPoint;
    }

    public Integer getCustomerId() {
        return customerId;
    }
    public Integer getHoldingPoint() {
        return holdingPoint;
    }

    public void addHoldingPointByCost(int cost) {
        this.holdingPoint += cost / RATE;
    }
}
