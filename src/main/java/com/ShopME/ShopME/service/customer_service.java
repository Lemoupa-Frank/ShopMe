package com.ShopME.ShopME.service;

import com.ShopME.ShopME.Repository.CustomerRepository;
import com.ShopME.ShopME.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class customer_service {
    public final CustomerRepository customerRepository;

    @Autowired
    public customer_service(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create_account(Customer customer)
    {
        return customerRepository.save(customer);
    }
}
