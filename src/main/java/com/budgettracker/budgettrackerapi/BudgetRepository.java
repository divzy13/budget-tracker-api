package com.budgettracker.budgettrackerapi;
import com.budgettracker.budgettrackerapi.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Transactions, Integer>{
    List<Transactions> findById(int Id);
}
