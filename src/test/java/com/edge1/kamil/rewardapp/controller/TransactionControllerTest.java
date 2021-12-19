package com.edge1.kamil.rewardapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.edge1.kamil.rewardapp.model.Customer;
import com.edge1.kamil.rewardapp.model.Transaction;
import com.edge1.kamil.rewardapp.repository.CustomerRepository;
import com.edge1.kamil.rewardapp.repository.TransactionRepository;
import com.edge1.kamil.rewardapp.view.TransactionDTO;

@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    TransactionController transactionController;

    @Test
    void shouldAddTransaction() {
        // given
        TransactionDTO transactionDTO = new TransactionDTO(100L, 1000d, 1L);
        Transaction transaction = new Transaction(100L, 1000d, new Date(2021, 9, 1), new Customer(1L, "TED"));
        final Customer ted = new Customer(1L, "TED");
        when(customerRepository.findById(1L)).thenReturn(Optional.of(ted));
        when(transactionRepository.save(any())).thenReturn(transaction);
        // when
        final ResponseEntity<TransactionDTO> transactionOfCustomer = transactionController.addNewTransactionOfCustomer(
                transactionDTO);
        // then
        verify(customerRepository, times(1)).findById(1L);
        verify(transactionRepository, times(1)).save(any());
        assertEquals(HttpStatus.CREATED, transactionOfCustomer.getStatusCode());
        assertEquals(transactionDTO.price(), transactionOfCustomer.getBody().price());
    }

    @Test
    void shouldUpdateTransaction() {
        // given
        TransactionDTO transactionDTO = new TransactionDTO(100L, 1000d, 1L);
        final Customer ted = new Customer(1L, "TED");
        when(customerRepository.findById(1L)).thenReturn(Optional.of(ted));
        // when
        final ResponseEntity<TransactionDTO> transactionOfCustomer = transactionController.updateTransactionOfCustomer(
                transactionDTO);
        // then
        verify(customerRepository, times(1)).findById(1L);
        verify(transactionRepository, times(1)).save(any());
        assertEquals(HttpStatus.OK, transactionOfCustomer.getStatusCode());
        assertEquals(transactionDTO, transactionOfCustomer.getBody());
    }
}