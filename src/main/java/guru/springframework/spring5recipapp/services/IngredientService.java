package guru.springframework.spring5recipapp.services;

import guru.springframework.spring5recipapp.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteByIngredientId(Long recipeId, Long ingredientId);


}
