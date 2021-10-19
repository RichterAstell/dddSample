package com.richter.dddsample.point.application;

import com.richter.dddsample.point.domain.HoldingPointEntity;
import com.richter.dddsample.point.domain.IHoldingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointUseAppService {
    private final IHoldingPointRepository holdingPointRepository;

    @Autowired
    public PointUseAppService(IHoldingPointRepository holdingPointRepository) {
        this.holdingPointRepository = holdingPointRepository;
    }

    public HoldingPointEntity use(int customerId, int hodlingPoint) {
        return new HoldingPointEntity(1, 90);
    }
}
