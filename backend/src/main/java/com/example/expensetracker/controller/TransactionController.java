package com.example.expensetracker.controller;

import com.example.expensetracker.model.Category;
import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.repository.CategoryRepository;
import com.example.expensetracker.repository.TransactionRepository;
import com.example.expensetracker.repository.UserRepository;
import com.example.expensetracker.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        // Ensure the category is set correctly
        if (transaction.getCategory() != null) {
            transaction.setUser(userRepository.findByEmail(UserUtils.getLoggedInUserEmail())); 
            Transaction savedTransaction = transactionRepository.save(transaction);
            return ResponseEntity.ok(savedTransaction);
        }
       return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findByUser(userRepository.findByEmail(UserUtils.getLoggedInUserEmail()));
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transactionDetails) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (!optionalTransaction.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Transaction transaction = optionalTransaction.get();
        transaction.setAmount(transactionDetails.getAmount());
        transaction.setDate(transactionDetails.getDate());
        transaction.setDescription(transactionDetails.getDescription());

        // Set the category if it exists
        if (transactionDetails.getCategory() != null) {
            Optional<Category> category = categoryRepository.findById(transactionDetails.getCategory().getId());
            category.ifPresent(transaction::setCategory);
        }

        Transaction updatedTransaction = transactionRepository.save(transaction);
        return ResponseEntity.ok(updatedTransaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        if (!transactionRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        transactionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}