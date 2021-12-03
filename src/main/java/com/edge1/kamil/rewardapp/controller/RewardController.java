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
import com.edge1.kamil.rewardapp.view.CustomerPointsDTO;
import com.edge1.kamil.rewardapp.service.RewardService;
import com.edge1.kamil.rewardapp.service.TransactionService;

@RestController
@RequestMapping("/api/reward-program")
class RewardController {

    private final RewardService rewardService;
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionService transactionService;

    RewardController(RewardService rewardService,
            CustomerRepository customerRepository,
            TransactionRepository transactionRepository,
            TransactionService transactionService) {
        this.rewardService = rewardService;
        this.transactionService = transactionService;
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/{customerId}/month-score")
    ResponseEntity<CustomerPointsDTO> getCustomerMonthScore(@PathVariable Long customerId) {
        List<Transaction> transactionsOfCustomer = transactionRepository.findByCustomerId(customerId);
        if (!transactionsOfCustomer.isEmpty()) {
            List<Transaction> transactionsFromMonth = transactionService.selectTransactionsFromPrevMonth(
                    transactionsOfCustomer);

            String customer = customerRepository.findById(customerId).get().getName();
            final int monthUserScore = rewardService.sumRewardPoints(transactionsFromMonth);
            return new ResponseEntity<>(new CustomerPointsDTO(customer, monthUserScore), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{customerId}/total-score")
    ResponseEntity<CustomerPointsDTO> getCustomerTotalScore(@PathVariable Long customerId) {
        List<Transaction> transactionsOfCustomer = transactionRepository.findByCustomerId(customerId);
        if (!transactionsOfCustomer.isEmpty()) {
            final int totalPoints = rewardService.sumRewardPoints(transactionsOfCustomer);
            String customer = customerRepository.findById(customerId).get().getName();
            return new ResponseEntity<>(new CustomerPointsDTO(customer, totalPoints), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
