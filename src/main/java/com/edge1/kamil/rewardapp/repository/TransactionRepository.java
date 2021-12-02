package com.edge1.kamil.rewardapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edge1.kamil.rewardapp.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}