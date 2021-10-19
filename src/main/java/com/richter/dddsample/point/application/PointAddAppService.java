package com.richter.dddsample.point.application;

import com.richter.dddsample.point.domain.HoldingPointEntity;
import com.richter.dddsample.point.domain.IHoldingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointAddAppService {
    private final IHoldingPointRepository holdingPointRepository;

    @Autowired
    public PointAddAppService(IHoldingPointRepository holdingPointRepository) {
        this.holdingPointRepository = holdingPointRepository;
    }

    public HoldingPointEntity add(int customerId, int cost) {
        // 既存保有ポイントを取得
        HoldingPointEntity holdingPoint = this.holdingPointRepository.findByCustomerId(customerId);
        // 保有ポイントを加算
        if (holdingPoint != null) {
            holdingPoint.addHoldingPointByCost(cost);
        } else {
            holdingPoint = new HoldingPointEntity(customerId, cost/100);
        }
        // TODO: ポイント付与履歴を作成

        // 保有ポイントを保存
        this.holdingPointRepository.save(holdingPoint);

        return holdingPoint;
    }
}
