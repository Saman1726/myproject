package com.example.expensetracker.controller;

import com.example.expensetracker.model.Category;
import com.example.expensetracker.repository.CategoryRepository;
import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.repository.TransactionRepository;
import com.example.expensetracker.repository.UserRepository;
import com.example.expensetracker.util.UserUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TransactionControllerTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransaction() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Test Category");

        Transaction transaction = new Transaction();
        transaction.setAmount(100.0);
        transaction.setDescription("Test Transaction");
        transaction.setCategory(category); 

        when(transactionRepository.save(transaction)).thenReturn(transaction);

        ResponseEntity<Transaction> response = transactionController.createTransaction(transaction);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(transaction.getAmount(), response.getBody().getAmount());
        verify(transactionRepository, times(1)).save(transaction);
    }

    @Test
    void testDeleteTransaction() {
        Long transactionId = 1L;

        when(transactionRepository.existsById(transactionId)).thenReturn(true);

        ResponseEntity<Void> response = transactionController.deleteTransaction(transactionId);

        assertEquals(204, response.getStatusCode().value());
        verify(transactionRepository, times(1)).deleteById(transactionId);
    }

    @Test
    void testGetAllTransactions() {
        Transaction transaction1 = new Transaction();
        transaction1.setAmount(100.0);
        transaction1.setDescription("Transaction 1");

        Transaction transaction2 = new Transaction();
        transaction2.setAmount(200.0);
        transaction2.setDescription("Transaction 2");

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2);

        when(transactionRepository.findByUser(userRepository.findByEmail(UserUtils.getLoggedInUserEmail()))).thenReturn(transactions);

        ResponseEntity<List<Transaction>> response = transactionController.getAllTransactions();

        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, response.getBody().size());
        verify(transactionRepository, times(1)).findByUser(userRepository.findByEmail(UserUtils.getLoggedInUserEmail()));
    }

    @Test
    void testGetTransactionById() {
        Long transactionId = 1L;
        Transaction transaction = new Transaction();
        transaction.setId(transactionId);
        transaction.setAmount(100.0);
        transaction.setDescription("Test Transaction");

        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(transaction));

        ResponseEntity<Transaction> response = transactionController.getTransactionById(transactionId);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(transaction.getId(), response.getBody().getId());
        verify(transactionRepository, times(1)).findById(transactionId);
    }

    @Test
    void testUpdateTransaction() {
        Long transactionId = 1L;
        Transaction existingTransaction = new Transaction();
        existingTransaction.setId(transactionId);
        existingTransaction.setAmount(100.0);
        existingTransaction.setDescription("Old Description");

        Transaction updatedTransaction = new Transaction();
        updatedTransaction.setAmount(200.0);
        updatedTransaction.setDescription("Updated Description");

        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(existingTransaction));
        when(transactionRepository.save(any(Transaction.class))).thenReturn(updatedTransaction);

        ResponseEntity<Transaction> response = transactionController.updateTransaction(transactionId, updatedTransaction);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(updatedTransaction.getAmount(), response.getBody().getAmount());
        assertEquals(updatedTransaction.getDescription(), response.getBody().getDescription());
        verify(transactionRepository, times(1)).save(existingTransaction);
    }
}
