package com.ShopME.ShopME.Repository;

import com.ShopME.ShopME.models.Order;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

@Hidden
public interface OrderRepository extends CrudRepository<Order, String> {

}