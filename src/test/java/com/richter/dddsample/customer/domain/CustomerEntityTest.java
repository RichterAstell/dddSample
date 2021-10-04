package com.richter.dddsample.customer.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CustomerEntityTest {
    @Test
    public void 顧客情報作成のテスト() {
        CustomerEntity customer = new CustomerEntity(Gender.MALE, LocalDate.of(2021, 1, 20));
        Assertions.assertEquals(1, customer.getGenderCode());
        Assertions.assertEquals("男性", customer.getGenderName());
        Assertions.assertEquals(LocalDate.of(2021, 1, 20), customer.getBirthday());
    }
}
