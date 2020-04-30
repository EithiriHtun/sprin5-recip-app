package guru.springframework.spring5recipapp.repositories;

import guru.springframework.spring5recipapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
