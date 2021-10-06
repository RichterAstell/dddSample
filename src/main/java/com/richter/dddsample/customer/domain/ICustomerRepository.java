package com.richter.dddsample.customer.domain;

public interface ICustomerRepository {
    public CustomerEntity findById(String customerId);
}
