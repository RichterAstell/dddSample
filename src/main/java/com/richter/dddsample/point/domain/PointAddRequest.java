package com.richter.dddsample.point.domain;

public record PointAddRequest(
        Integer customerId,
        Integer cost
) {}
