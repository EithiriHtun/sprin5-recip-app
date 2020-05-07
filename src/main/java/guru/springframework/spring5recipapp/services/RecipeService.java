package guru.springframework.spring5recipapp.services;

import guru.springframework.spring5recipapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
