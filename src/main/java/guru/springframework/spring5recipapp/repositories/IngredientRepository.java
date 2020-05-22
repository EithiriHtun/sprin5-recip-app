package guru.springframework.spring5recipapp.repositories;

import guru.springframework.spring5recipapp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
