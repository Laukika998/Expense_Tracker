package io.main.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.main.model.Expense;
import io.main.repository.ExpenseRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Map<LocalDate, Double> getDailyReports() {
        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .collect(Collectors.groupingBy(Expense::getDate,
                        Collectors.summingDouble(Expense::getAmount)));
    }
}
