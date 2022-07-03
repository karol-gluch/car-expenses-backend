package pl.gluch.carexpenses.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.gluch.carexpenses.model.Expense;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    @Query("SELECT COUNT(e) " +
            "FROM Expense AS e")
    public Long getNumberOfExpenses();

    @Query("SELECT SUM(e.cost) " +
            "FROM Expense AS e")
    public BigDecimal getSumOfCosts();

    @Query("SELECT e.category.name, sum(e.cost) " +
            "FROM Expense AS e " +
            "GROUP BY e.category.name")
    public List<Object[]> getSumOfCostsByCategory();
}
