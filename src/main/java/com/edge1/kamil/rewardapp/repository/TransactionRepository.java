package com.edge1.kamil.rewardapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.edge1.kamil.rewardapp.model.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findByCustomerId(List<Long> customerId);
}