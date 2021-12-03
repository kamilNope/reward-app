package com.edge1.kamil.rewardapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.edge1.kamil.rewardapp.model.Transaction;

@Service
public class TransactionService {

    public List<Transaction> selectTransactionsFromPrevMonth(List<Transaction> transactions){
        LocalDate previousMontDate = LocalDate.now().minusMonths(1L);
        return transactions.stream()
                .filter(transaction -> previousMontDate.isBefore(transaction.getDate().toLocalDate()))
                .collect(Collectors.toList());
    }

}
