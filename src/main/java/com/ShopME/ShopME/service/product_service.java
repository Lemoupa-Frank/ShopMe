package com.ShopME.ShopME.service;

import com.ShopME.ShopME.Repository.CouponRepository;
import com.ShopME.ShopME.Repository.ProductRepository;
import com.ShopME.ShopME.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
