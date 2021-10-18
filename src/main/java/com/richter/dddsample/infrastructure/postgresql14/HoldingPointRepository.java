package com.richter.dddsample.infrastructure.postgresql14;

import com.richter.dddsample.customer.domain.CustomerEntity;
import com.richter.dddsample.infrastructure.postgresql14.query.PointAddQuery;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import com.richter.dddsample.point.domain.IHoldingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class HoldingPointRepository implements IHoldingPointRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public HoldingPointRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer save(HoldingPointEntity holdingPoint) {
        holdingPoint.setCustomerId(2);
        // 実行する SQL を組み立てる
        PointAddQuery pointAddQuery = new PointAddQuery();
        pointAddQuery.setCustomerId(holdingPoint.getCustomerId())
                .setHoldingPoint(holdingPoint.getHoldingPoint());
        String query = PointAddQuery.getQuery();
        RowMapper<HoldingPointEntity> mapper = new BeanPropertyRowMapper(HoldingPointEntity.class);

        Integer result = this.jdbcTemplate.update(query, pointAddQuery.getParameters());

        return result;
    }

    @Override
    public HoldingPointEntity findByCustomerId(int customerId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("customer_id", customerId);

        // 実行する SQL を組み立てる
        String query = "select * from holding_point where customer_id = :customer_id";

        RowMapper<HoldingPointEntity> rowMapper = new BeanPropertyRowMapper(HoldingPointEntity.class);
        HoldingPointEntity holdingPoint = this.jdbcTemplate.queryForObject(query, parameters, rowMapper);

        return holdingPoint;
    }
}
