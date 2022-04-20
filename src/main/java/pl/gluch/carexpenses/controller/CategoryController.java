package pl.gluch.carexpenses.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gluch.carexpenses.model.Category;
import pl.gluch.carexpenses.service.CategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getListOfCategories();
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody final Category category) {
        return categoryService.saveCategory(category);
    }

}
