package com.ShopME.ShopME.Repository;

import com.ShopME.ShopME.models.Transaction;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.repository.CrudRepository;

@Hidden
public interface TransactionRepository extends CrudRepository<Transaction, String> {

}