package com.richter.dddsample.infrastructure.postgresql;

import com.richter.dddsample.customer.domain.CustomerEntity;
import com.richter.dddsample.customer.domain.Gender;
import com.richter.dddsample.infrastructure.postgresql14.CustomerRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;

import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    @Test
    void 顧客IDでの検索() {
        // 検証データの作成
        LocalDate birthday = LocalDate.of(2021, 10, 20);
        CustomerEntity customer = new CustomerEntity(1
                , Gender.NOT_KNOWN, birthday);
        // モックの作成
        JdbcTemplate template = Mockito.mock(JdbcTemplate.class);

        Mockito.when(template.queryForObject(
                        anyString()
                        , any(RowMapper.class)
                        , anyInt()))
                .thenReturn(customer);
        // テスト対象の作成
        CustomerRepository repository = new CustomerRepository(template);
        // 実行
        CustomerEntity act = repository.findById(1);
        // 検証
        assertEquals(1, act.getCustomerId());
        assertEquals(Gender.NOT_KNOWN, act.getGender());
        assertEquals(birthday, act.getBirthday());
    }
}