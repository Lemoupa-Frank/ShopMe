package com.ShopME.ShopME.Repository;

import com.ShopME.ShopME.models.Product;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Hidden
public interface ProductRepository extends CrudRepository<Product, String> {
    @Transactional
    @Modifying
    @Query("update Product p set p.ordered = ?1, p.available = ?2 where p.prouductId = ?3")
    int updateOrderedAndAvailableByProuductId(Long ordered, Long available, String prouductId);
    @Transactional
    @Modifying
    @Query("update Product p set p.available = ?1 where p.prouductId = ?2")
    int updateAvailableByProuductId(Long available, String prouductId);

}