package com.richter.dddsample.infrastructure.postgresql;

import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;

class HoldingPointRepositoryTest {
    @Test
    public void 顧客IDから保有ポイント取得のテスト() {
        // 検証データの作成
        HoldingPointEntity holdingPoint = new HoldingPointEntity(1, 100);

        // モックの作成
        JdbcTemplate template = Mockito.mock(JdbcTemplate.class);
        Mockito.when(template.queryForObject(
                        anyString()
                        , any(RowMapper.class)
                        , anyInt()))
                .thenReturn(holdingPoint);

        // テスト対象の作成
        HoldingPointRepository repository = new HoldingPointRepository(template);

        // 実行
        HoldingPointEntity act = repository.findByCustomerId(1);

        // 検証
        assertEquals(1, act.getCustomerId());
        assertEquals(100, act.getHoldingPoint());
    }

    @Test
    public void 保有ポイント登録のテスト() {
        // 検証データの作成
        HoldingPointEntity holdingPoint = new HoldingPointEntity(1, 100);

        // モックの作成
        JdbcTemplate template = Mockito.mock(JdbcTemplate.class);
        Mockito.when(template.queryForObject(
                        anyString()
                        , any(RowMapper.class)
                        , anyInt()))
                .thenReturn(holdingPoint);

        // テスト対象の作成
        HoldingPointRepository repository = new HoldingPointRepository(template);

        // 実行
        HoldingPointEntity act = repository.findByCustomerId(1);

        // 検証
        assertEquals(1, act.getCustomerId());
        assertEquals(100, act.getHoldingPoint());
    }
}
