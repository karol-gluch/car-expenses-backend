package pl.gluch.carexpenses.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gluch.carexpenses.model.Category;
import pl.gluch.carexpenses.model.Expense;
import pl.gluch.carexpenses.model.ExpenseDto;
import pl.gluch.carexpenses.repository.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public List<Category> getListOfCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

}
