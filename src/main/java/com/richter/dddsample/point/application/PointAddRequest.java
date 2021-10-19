package com.richter.dddsample.point.application;

public record PointAddRequest(
        Integer customerId,
        Integer cost
) {}
