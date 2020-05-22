package guru.springframework.spring5recipapp.services;

import guru.springframework.spring5recipapp.commands.RecipeCommand;
import guru.springframework.spring5recipapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}
