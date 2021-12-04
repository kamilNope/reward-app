package com.edge1.kamil.rewardapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.edge1.kamil.rewardapp.model.Customer;
import com.edge1.kamil.rewardapp.model.Transaction;
import com.edge1.kamil.rewardapp.repository.CustomerRepository;
import com.edge1.kamil.rewardapp.repository.TransactionRepository;
import com.edge1.kamil.rewardapp.view.CustomerPointsDTO;
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
        final Customer ted = new Customer(1L, "TED");
        final Optional<List<Transaction>> tedTran = Optional.of(List.of(
                new Transaction(1L, 99.0, Date.valueOf(LocalDate.now()), ted)));
        when(customerRepository.findById(1L)).thenReturn(Optional.of(ted));
        when(transactionRepository.findByCustomerId(any())).thenReturn(tedTran);
        // when
        final ResponseEntity<CustomerPointsDTO> customerMonthScore = rewardController.getCustomerMonthScore(1L);
        // then
        verify(rewardService, times(1)).sumRewardPoints(tedTran.get());
        verify(transactionService, times(1)).selectTransactionsFromPrevMonth(tedTran.get());
        verify(customerRepository, times(1)).findById(1L);
        assertEquals(HttpStatus.OK, customerMonthScore.getStatusCode());
        assertEquals(49, customerMonthScore.getBody().getCustomerScore());
    }

    @Test
    void shouldReturnErrorHandle() {
        // when
        assertThrows(CustomApiException.class, () -> rewardController.getCustomerMonthScore(13L));
        // then
        verify(transactionRepository, times(1)).findByCustomerId(13L);
        verify(customerRepository, never()).findById(13L);
    }

}