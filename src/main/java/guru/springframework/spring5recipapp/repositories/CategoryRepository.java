package guru.springframework.spring5recipapp.repositories;

import guru.springframework.spring5recipapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
