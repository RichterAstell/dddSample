package com.richter.dddsample.point.domain;

public record PointUseRequest(
        Integer customerId,
        Integer HoldingPoint
) {
}
