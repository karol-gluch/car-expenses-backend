package pl.gluch.carexpenses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gluch.carexpenses.model.Expense;
import pl.gluch.carexpenses.model.ExpenseDto;
import pl.gluch.carexpenses.service.ExpenseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/expenses")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseService.getListOfExpenses();
    }

    @PostMapping("/save")
    public Expense saveExpense(@RequestBody final ExpenseDto expense) {
        return expenseService.saveExpense(expense);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpense(@PathVariable final Long id) {
        expenseService.deleteExpense(id);
    }
}
