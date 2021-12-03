package com.edge1.kamil.rewardapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.edge1.kamil.rewardapp.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}