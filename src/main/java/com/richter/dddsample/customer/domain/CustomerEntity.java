package com.richter.dddsample.customer.domain;

import java.time.LocalDate;

public class CustomerEntity {
    private String customerId;
    private Gender gender;
    private LocalDate birthday;

    public CustomerEntity(Gender gender, LocalDate birthday) {
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getCustomerId() {
        return customerId;
    }
    public Gender getGender() {
        return gender;
    }
    public Integer getGenderCode() {
        return gender.getCode();
    }
    public String getGenderName() {
        return gender.getName();
    }
    public LocalDate getBirthday() {
        return birthday;
    }
}
