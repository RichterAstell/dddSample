package com.richter.dddsample.infrastructure.postgresql;

import com.richter.dddsample.customer.domain.CustomerEntity;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import com.richter.dddsample.point.domain.IHoldingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class HoldingPointRepository implements IHoldingPointRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HoldingPointRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public HoldingPointEntity save(HoldingPointEntity holdingPoint) {
        // 実行する SQL を組み立てる
        SqlParameterSource param = new BeanPropertySqlParameterSource(holdingPoint);
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(jdbcTemplate)
                        .withTableName("holdingPoint")
                        .usingGeneratedKeyColumns("customerId");
        // SQL を実行して、AUTO_INCREMENT の値を取得する
        Number key = insert.executeAndReturnKey(param);

        return new HoldingPointEntity(key.intValue()
                , holdingPoint.getHoldingPoint());
    }

    @Override
    public HoldingPointEntity findByCustomerId(int customerId) {
        // 実行する SQL を組み立てる
        String query = "select * from holdingPoint where customerId = ?";

        RowMapper<HoldingPointEntity> rowMapper = new BeanPropertyRowMapper(HoldingPointEntity.class);
        HoldingPointEntity holdingPoint = this.jdbcTemplate.queryForObject(query, rowMapper, customerId);

        return holdingPoint;
    }
}
