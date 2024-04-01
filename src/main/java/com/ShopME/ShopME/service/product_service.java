package com.ShopME.ShopME.service;

import com.ShopME.ShopME.Repository.ProductRepository;
import com.ShopME.ShopME.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class product_service {
    public final ProductRepository productrepository;

    @Autowired
    public product_service(ProductRepository productrepository) {
        this.productrepository = productrepository;
    }

    public Iterable<Product> get_product()
    {
        return productrepository.findAll();
    }

    public void update_product(Long ordered, Long available){
        productrepository.updateOrderedAndAvailableByProuductId(ordered,available,"pd0021");}

    public Optional<Product> get_a_product(){
        return productrepository.findById("pd0021");
    }
}
