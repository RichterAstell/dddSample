package com.richter.dddsample.infrastructure.postgresql;

import com.richter.dddsample.point.domain.HoldingPointHistoryEntity;
import com.richter.dddsample.point.domain.IHoldingPointHistoryRepository;
import com.richter.dddsample.point.domain.UseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class HoldingPointHistoryRepository implements IHoldingPointHistoryRepository {
    private JdbcTemplate template;

    @Autowired
    public HoldingPointHistoryRepository(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public HoldingPointHistoryEntity save(HoldingPointHistoryEntity history) {
        // 実行する SQL を組み立てる
        SqlParameterSource param = new BeanPropertySqlParameterSource(history);
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(this.template)
                        .withTableName("holdingPointHistory")
                        .usingGeneratedKeyColumns("historyId");
        // SQL を実行して、AUTO_INCREMENT の値を取得する
        Number key = insert.executeAndReturnKey(param);

        return new HoldingPointHistoryEntity(key.intValue()
                , history.getCustomerId()
                , history.getHoldingPoint()
                , UseType.Add);
    }
}
