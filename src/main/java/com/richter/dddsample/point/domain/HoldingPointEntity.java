package com.richter.dddsample.point.domain;

import javax.persistence.Id;

public class HoldingPointEntity {
    private String customerId;
    private Integer holdingPoint;

    public HoldingPointEntity(String customerId, Integer holdingPoint) {
        if (customerId == null || customerId.isEmpty()) {
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

    public String getCustomerId() {
        return customerId;
    }
    public Integer getHoldingPoint() {
        return holdingPoint;
    }
}
