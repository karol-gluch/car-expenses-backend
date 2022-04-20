package pl.gluch.carexpenses.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.gluch.carexpenses.model.Category;
import pl.gluch.carexpenses.model.Expense;
import pl.gluch.carexpenses.repository.CategoryRepository;
import pl.gluch.carexpenses.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@Component
public class Start {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {

        Category category = new Category();
        category.setId(1L);
        category.setName("Paliwo");
        category.setColor("#db9a0d");
        categoryRepository.save(category);

        Category category1 = new Category();
        category1.setId(2L);
        category1.setName("Serwis");
        category1.setColor("#0ea600");
        categoryRepository.save(category1);

        Expense expense = new Expense();
        expense.setId(1L);
        expense.setCategory(category);
        expense.setCost(new BigDecimal(200));
        expense.setPlace("Amic - Warszawska, Kielce");
        expense.setActualDate(LocalDate.now());
        expense.setName("Tankowanie");
        expenseRepository.save(expense);

        Expense expense1 = new Expense();
        expense1.setId(2L);
        expense1.setCategory(category1);
        expense1.setCost(new BigDecimal(120));
        expense1.setPlace("Samsonów - sklep motoryzacyjny");
        expense1.setActualDate(LocalDate.now());
        expense1.setName("Olej 5W40 Motul");
        expenseRepository.save(expense1);
    }
}
