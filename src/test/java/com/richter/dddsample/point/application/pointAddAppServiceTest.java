package com.richter.dddsample.point.application;

import com.richter.dddsample.infrastructure.postgresql.HoldingPointRepository;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import com.richter.dddsample.point.domain.IHoldingPointRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.*;

public class pointAddAppServiceTest {
    @Test
    public void 新規ポイント加算のテスト() {
        // 検証データの作成
        // モックの作成
        IHoldingPointRepository repository = Mockito.mock(IHoldingPointRepository.class);
        Mockito.when(repository.findByCustomerId(anyInt()))
                .thenReturn(null);
        Mockito.when(repository.save(any(HoldingPointEntity.class)))
                .thenReturn(1);
        // テスト対象の作成
        pointAddAppService appService = new pointAddAppService(repository);
        // 実行
        HoldingPointEntity result = appService.add(1,1234);
        // 検証
        Assertions.assertEquals(12, result.getHoldingPoint());
    }
    @Test
    public void 既存ポイント加算のテスト() {
        // 検証データの作成
        HoldingPointEntity oldEntity = new HoldingPointEntity(1, 100);
        // モックの作成
        HoldingPointRepository repository = Mockito.mock(HoldingPointRepository.class);
        Mockito.when(repository.findByCustomerId(anyInt()))
                .thenReturn(oldEntity);
        Mockito.when(repository.save(any(HoldingPointEntity.class)))
                .thenReturn(1);
        // テスト対象の作成
        pointAddAppService appService = new pointAddAppService(repository);
        // 実行
        HoldingPointEntity result = appService.add(1,1234);
        // 検証
        Assertions.assertEquals(112, result.getHoldingPoint());
    }
}
