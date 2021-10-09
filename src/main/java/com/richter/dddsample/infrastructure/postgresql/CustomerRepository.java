package com.richter.dddsample.infrastructure.postgresql;

import com.richter.dddsample.customer.domain.CustomerEntity;
import com.richter.dddsample.customer.domain.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomerRepository implements ICustomerRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CustomerEntity findById(Integer customerId) {
        // 実行する SQL を組み立てる
        String query = "select * from customer where customerId = ?";

        RowMapper<CustomerEntity> rowMapper = new BeanPropertyRowMapper(CustomerEntity.class);
        CustomerEntity customer = this.jdbcTemplate.queryForObject(query, rowMapper, customerId);

        return customer;
    }
}
