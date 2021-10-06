package com.richter.dddsample.infrastructure.postgresql;

import com.richter.dddsample.customer.domain.CustomerEntity;
import com.richter.dddsample.customer.domain.Gender;
import com.richter.dddsample.customer.domain.ICustomerRepository;
import com.richter.dddsample.point.domain.HoldingPointEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;

public class CustomerRepository implements ICustomerRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CustomerEntity findById(String customerId) {
        // 実行する SQL を組み立てる
        String query = "select * from customer where customerId = ?";

        RowMapper<CustomerEntity> rowMapper = new BeanPropertyRowMapper<CustomerEntity>(CustomerEntity.class);
        CustomerEntity customer = jdbcTemplate.queryForObject(query, rowMapper, customerId);

        return customer;
    }
}
