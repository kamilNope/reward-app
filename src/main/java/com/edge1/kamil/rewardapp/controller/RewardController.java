package com.edge1.kamil.rewardapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edge1.kamil.rewardapp.model.Transaction;
import com.edge1.kamil.rewardapp.repository.CustomerRepository;
import com.edge1.kamil.rewardapp.repository.TransactionRepository;
import com.edge1.kamil.rewardapp.service.CustomerPointsRecord;
import com.edge1.kamil.rewardapp.service.RewardService;
import com.edge1.kamil.rewardapp.service.TransactionService;

@RestController("")
@RequestMapping("api/reward-program")
class RewardController {

    private final RewardService rewardService;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    RewardController(RewardService rewardService,
            CustomerRepository customerRepository,
            TransactionRepository transactionRepository,
            TransactionService transactionService){
        this.rewardService = rewardService;
        this.transactionService = transactionService;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping ("/{customerId}")
    ResponseEntity<CustomerPointsRecord> getCustomerMonthScore(@PathVariable Long customerId){
        List<Transaction> transactionsOfCustomer = transactionRepository.findByCustomerId(List.of(customerId));
        List<Transaction> transactionsFromMonth = transactionService.selectTransactionsFromPreviousMonth(transactionsOfCustomer);
        if(!transactionsOfCustomer.isEmpty()){
            rewardService.sumRewardPoints(0.0);
            return new ResponseEntity<>(new CustomerPointsRecord(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping ("/{userId}")
    CustomerPointsRecord getUserTotalScore(@PathVariable String userId){
        rewardService.sumRewardPoints(0.0);
        return new CustomerPointsRecord();
    }

}
