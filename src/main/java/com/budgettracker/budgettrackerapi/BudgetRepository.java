package com.budgettracker.budgettrackerapi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<BudgetModel, Integer>{
    List<BudgetModel> findById(int Id);
}
