package com.ShopME.ShopME.Repository;

import com.ShopME.ShopME.models.Product;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.repository.CrudRepository;

@Hidden
public interface ProductRepository extends CrudRepository<Product, String> {

}