package com.richter.dddsample.point.application;

public class pointAddAppService {
    private static Integer POINT_RETE = 100;
    public Integer add(int cost) {
        return cost / POINT_RETE;
    }
}
