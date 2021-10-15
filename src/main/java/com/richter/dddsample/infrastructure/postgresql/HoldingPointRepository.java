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
import org.springframework.stereotype.Repository;

@Repository
public class HoldingPointRepository implements IHoldingPointRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HoldingPointRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer save(HoldingPointEntity holdingPoint) {
        holdingPoint.setCustomerId(2);
        // 実行する SQL を組み立てる
        SqlParameterSource param = new BeanPropertySqlParameterSource(holdingPoint);
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(jdbcTemplate)
                        .withTableName("holding_point");
        // SQL を実行して、AUTO_INCREMENT の値を取得する
        Integer rows = insert.execute(param);

        return rows;
    }

    @Override
    public HoldingPointEntity findByCustomerId(int customerId) {
        // 実行する SQL を組み立てる
        String query = "select * from holding_point where customer_id = ?";

        RowMapper<HoldingPointEntity> rowMapper = new BeanPropertyRowMapper(HoldingPointEntity.class);
        HoldingPointEntity holdingPoint = this.jdbcTemplate.queryForObject(query, rowMapper, customerId);

        return holdingPoint;
    }
}
