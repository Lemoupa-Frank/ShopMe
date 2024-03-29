package com.ShopME.ShopME.Repository;

import com.ShopME.ShopME.models.Customer;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.repository.CrudRepository;


@Hidden
public interface CustomerRepository extends CrudRepository<Customer, String> {

}