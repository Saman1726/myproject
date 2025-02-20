package com.example.expensetracker.repository;

import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUser(User user);
}