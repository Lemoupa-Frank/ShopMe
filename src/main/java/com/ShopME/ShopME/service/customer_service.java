package com.ShopME.ShopME.service;

import com.ShopME.ShopME.Repository.CustomerRepository;
import com.ShopME.ShopME.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<Customer> getCustomer(String id)
    {
        return customerRepository.findById(id);
    }

    /**
     * Sets a coupon as used
     * @param user_id the id of the customer
     */
    public void update_coupon_to_used(String user_id)
    {
        customerRepository.updateCoupon_statusByUserId("Used",user_id);
    }

    public void add_coupon(String user_id, String coupon_id)
    {
        customerRepository.updateCoupon_statusAndCouponIdByUserId("unused",coupon_id,user_id);
    }

    public Iterable<Customer> list_of_users()
    {
        return customerRepository.findAll();
    }
}
