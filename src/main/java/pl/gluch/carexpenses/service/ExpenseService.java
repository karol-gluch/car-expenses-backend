package pl.gluch.carexpenses.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gluch.carexpenses.model.Category;
import pl.gluch.carexpenses.model.Expense;
import pl.gluch.carexpenses.model.ExpenseDto;
import pl.gluch.carexpenses.repository.ExpenseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final CategoryService categoryService;

    public List<Expense> getListOfExpenses() {
        return (List<Expense>) expenseRepository.findAll();
    }

    public Expense saveExpense(ExpenseDto expenseDto) {
        Category category = categoryService.findCategoryById(expenseDto.getCategoryId());
        Expense expense = ExpenseDto.mapToExpense(expenseDto, category);
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
