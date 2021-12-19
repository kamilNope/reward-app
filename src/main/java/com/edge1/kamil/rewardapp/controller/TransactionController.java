package com.edge1.kamil.rewardapp.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edge1.kamil.rewardapp.model.Customer;
import com.edge1.kamil.rewardapp.model.Transaction;
import com.edge1.kamil.rewardapp.repository.CustomerRepository;
import com.edge1.kamil.rewardapp.repository.TransactionRepository;
import com.edge1.kamil.rewardapp.view.TransactionDTO;

@RestController
@RequestMapping(value = "/api/transactions")
class TransactionController {

    final TransactionRepository transactionRepository;
    final CustomerRepository customerRepository;

    TransactionController(TransactionRepository transactionRepository,
            CustomerRepository customerRepository) {
        this.transactionRepository = transactionRepository;
        this.customerRepository = customerRepository;
    }

    @PostMapping(value = "/add")
    ResponseEntity<TransactionDTO> addNewTransactionOfCustomer(@RequestBody TransactionDTO transactionDTO) {
        Customer customer = customerRepository.findById(transactionDTO.customerId())
                .orElseThrow(() -> new CustomApiException(transactionDTO.customerId().toString()));
        Transaction transaction = new Transaction(transactionDTO.id(), transactionDTO.price(), Date.valueOf(LocalDate.now()), customer);
        final Transaction addedTransaction = transactionRepository.save(transaction);
        TransactionDTO resultTransaction = new TransactionDTO(addedTransaction.getId(), transactionDTO.price(), transactionDTO.customerId());
        return new ResponseEntity<>(resultTransaction, HttpStatus.CREATED);
    }


    @PutMapping(value = "/update")
    ResponseEntity<TransactionDTO> updateTransactionOfCustomer(@RequestBody TransactionDTO transactionDTO) {
        Customer customer = customerRepository.findById(transactionDTO.customerId())
                .orElseThrow(() -> new CustomApiException(transactionDTO.customerId().toString()));
        Transaction transaction = new Transaction(transactionDTO.id(), transactionDTO.price(), Date.valueOf(LocalDate.now()), customer);
        transactionRepository.save(transaction);
        return new ResponseEntity<>(transactionDTO, HttpStatus.OK);
    }

}
