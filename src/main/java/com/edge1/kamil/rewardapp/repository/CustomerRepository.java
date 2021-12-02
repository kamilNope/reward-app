package com.edge1.kamil.rewardapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.edge1.kamil.rewardapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(@Param("ID") Integer id);


}