package com.richter.dddsample.customer.domain;

public interface ICustomerRepository {
    CustomerEntity findById(Integer customerId);
}
