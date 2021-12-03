package com.edge1.kamil.rewardapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.edge1.kamil.rewardapp.model.Customer;
import com.edge1.kamil.rewardapp.model.Transaction;
import com.edge1.kamil.rewardapp.repository.CustomerRepository;
import com.edge1.kamil.rewardapp.repository.TransactionRepository;
import com.edge1.kamil.rewardapp.service.CustomerPointsRecord;
import com.edge1.kamil.rewardapp.service.RewardService;
import com.edge1.kamil.rewardapp.service.TransactionService;

@ExtendWith(MockitoExtension.class)
class RewardControllerTest {

    @Spy
    RewardService rewardService;
    @Spy
    TransactionService transactionService;
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    RewardController rewardController;

    @Test
    void shouldReturnMonthReward() {
        // given
        final List<Transaction> ted = List.of(
                new Transaction(1L, 99.0, Date.valueOf(
                        LocalDate.now()),
                        new Customer(1L, "TED")));
        when(transactionRepository.findByCustomerId(any())).thenReturn(ted);
        // when
        final ResponseEntity<CustomerPointsRecord> customerMonthScore = rewardController.getCustomerMonthScore(1L);
        // then
        assertEquals(HttpStatus.OK, customerMonthScore.getStatusCode());
        assertEquals(49, customerMonthScore.getBody().getMonthUserScore());
    }

}