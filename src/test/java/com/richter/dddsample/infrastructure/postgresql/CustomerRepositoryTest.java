package com.richter.dddsample.infrastructure.postgresql;

import com.richter.dddsample.customer.domain.CustomerEntity;
import com.richter.dddsample.customer.domain.Gender;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    @Test
    void 顧客IDでの検索() {

        LocalDate birthday = LocalDate.of(2021, 10, 20);
        CustomerEntity customer = new CustomerEntity("1"
                , Gender.NOT_KNOWN, birthday);

        JdbcTemplate template = Mockito.mock(JdbcTemplate.class);
        Mockito.when(template.queryForObject(
                        ArgumentMatchers.anyString()
                        , ArgumentMatchers.any(BeanPropertyRowMapper.class)
                        , ArgumentMatchers.anyString()))
                .thenReturn(customer);
        CustomerRepository repository = new CustomerRepository(template);
        CustomerEntity act = repository.findById("1");
        assertEquals("1", act.getCustomerId());
        assertEquals(Gender.NOT_KNOWN, act.getGender());
        assertEquals(birthday, act.getBirthday());
    }
}