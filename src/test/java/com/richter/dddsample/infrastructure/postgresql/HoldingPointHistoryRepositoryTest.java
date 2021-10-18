package com.richter.dddsample.infrastructure.postgresql;

import com.richter.dddsample.infrastructure.postgresql14.HoldingPointHistoryRepository;
import com.richter.dddsample.infrastructure.postgresql14.HoldingPointRepository;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import com.richter.dddsample.point.domain.HoldingPointHistoryEntity;
import com.richter.dddsample.point.domain.IHoldingPointHistoryRepository;
import com.richter.dddsample.point.domain.UseType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

class HoldingPointHistoryRepositoryTest {
    @Test @Disabled("not ready yet")
    public void 保有ポイント履歴保存のテスト() {
        // 検証データの作成
        HoldingPointHistoryEntity entity = new HoldingPointHistoryEntity(1, 1, 100, UseType.Add);

        // モックの作成
        JdbcTemplate template = Mockito.mock(JdbcTemplate.class);

        // テスト対象の作成
        IHoldingPointHistoryRepository repository = new HoldingPointHistoryRepository(template);

        // 実行
        HoldingPointHistoryEntity act = repository.save(entity);

        // 検証
        assertEquals(1, act.getCustomerId());
        assertEquals(100, act.getHoldingPoint());
        assertEquals(UseType.Add, act.getUseType());
    }

    @Test
    public void 保有ポイント登録のテスト() {
        // 検証データの作成
        HoldingPointEntity holdingPoint = new HoldingPointEntity(1, 100);

        // モックの作成
        NamedParameterJdbcTemplate template = Mockito.mock(NamedParameterJdbcTemplate.class);
        Mockito.when(template.queryForObject(
                        anyString()
                        , any(MapSqlParameterSource.class)
                        , any(RowMapper.class)))
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
