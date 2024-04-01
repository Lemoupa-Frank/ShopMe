package com.ShopME.ShopME.service;

import com.ShopME.ShopME.Repository.TransactionRepository;
import com.ShopME.ShopME.models.Transaction;
import org.springframework.stereotype.Service;

@Service
public class transaction_service {
    public final TransactionRepository transactionRepository;

    public transaction_service(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction addtransaction(Transaction transaction)
    {
        return transactionRepository.save(transaction);
    }

    public Iterable<Transaction> getTransaction(String UserId, String OrderId)
    {
        return transactionRepository.findByUserIdAndOrderId(UserId,OrderId);
    }

    public boolean exist(String UserId, String OrderId){
        return transactionRepository.existsByUserIdAndOrderId(UserId,OrderId);
    }
}
