package com.edge1.kamil.rewardapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.edge1.kamil.rewardapp.model.Customer;
import com.edge1.kamil.rewardapp.model.Transaction;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}