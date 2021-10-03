package com.richter.dddsample.pointdomain;

public class pointAddAppService {
    private static Integer POINT_RETE = 100;
    public Integer add(int cost) {
        return cost / POINT_RETE;
    }
}
