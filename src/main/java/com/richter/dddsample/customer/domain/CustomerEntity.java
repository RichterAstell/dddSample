package com.richter.dddsample.customer.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
