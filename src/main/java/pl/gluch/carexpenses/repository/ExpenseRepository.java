package pl.gluch.carexpenses.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gluch.carexpenses.model.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {

}
