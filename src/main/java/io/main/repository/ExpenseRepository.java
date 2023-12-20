package io.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.main.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}


