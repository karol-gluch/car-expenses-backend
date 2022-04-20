package pl.gluch.carexpenses.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ExpenseDto {
    private Long id;
    private String name;
    private BigDecimal cost;
    private String place;
    private LocalDate actualDate;
    private Long categoryId;

    public static Expense mapToExpense(ExpenseDto expenseDto, Category category) {
        Expense expense = new Expense();
        expense.setName(expenseDto.getName());
        expense.setCost(expenseDto.getCost());
        expense.setPlace(expenseDto.getPlace());
        expense.setActualDate(expenseDto.getActualDate());
        expense.setCategory(category);
        return expense;
    }
}
