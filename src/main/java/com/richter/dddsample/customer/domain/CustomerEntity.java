package com.richter.dddsample.customer.domain;

import java.time.LocalDate;

public class CustomerEntity {
    private Integer customerId;
    private Gender gender;
    private LocalDate birthday;

    public CustomerEntity(Integer customerId, Gender gender, LocalDate birthday) throws IllegalArgumentException {
        this.customerId = customerId;
        if (gender == null) {
            throw new IllegalArgumentException("gender is require");
        }
        this.gender = gender;
        if (birthday == null) {
            throw new IllegalArgumentException("birthday is require");
        }
        this.birthday = birthday;
    }

    public Integer getCustomerId() {
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
