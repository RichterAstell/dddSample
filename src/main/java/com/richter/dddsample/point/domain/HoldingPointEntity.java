package com.richter.dddsample.point.domain;



import javax.persistence.*;

@Entity
@Table(name = "holding_point")
public class HoldingPointEntity {
    private static Integer RATE = 100;

    @Id
    @Column(name = "customer_id" ,nullable = false)
    private Integer customerId;
    @Column(name = "holding_point" ,nullable = false)
    private Integer holdingPoint;

    public HoldingPointEntity() {
    }

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

    public void addHoldingPointByCost(int cost) {
        this.holdingPoint += cost / RATE;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setHoldingPoint(Integer holdingPoint) {
        this.holdingPoint = holdingPoint;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getHoldingPoint() {
        return holdingPoint;
    }
}
