package pl.gluch.carexpenses.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gluch.carexpenses.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
