package com.budgettracker.budgettrackerapi;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class BudgetModel {

    @Id
    public int id;
    public int name;
    public int price;

}
