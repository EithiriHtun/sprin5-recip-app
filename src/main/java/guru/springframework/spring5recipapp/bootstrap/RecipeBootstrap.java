package guru.springframework.spring5recipapp.bootstrap;

import guru.springframework.spring5recipapp.domain.*;
import guru.springframework.spring5recipapp.repositories.CategoryRepository;
import guru.springframework.spring5recipapp.repositories.RecipeRepository;
import guru.springframework.spring5recipapp.repositories.UnitOfMountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private  final RecipeRepository recipeRepository;
    private final UnitOfMountRepository unitOfMountRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMountRepository unitOfMountRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMountRepository = unitOfMountRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        log.debug("Loading Bootstrap Data..");
    recipeRepository.saveAll(getRecipes());

    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipes = new ArrayList<>(2);

        //get Uoms
        Optional<UnitOfMount> eachUomOptional = unitOfMountRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM Not Found");
        }

        Optional<UnitOfMount> tableSpoonUomOptional = unitOfMountRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM Not Found");
        }

        Optional<UnitOfMount> teaSpoonUomOptional = unitOfMountRepository.findByDescription("Teaspoon");

        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM Not Found");
        }

        Optional<UnitOfMount> dashUomOptional = unitOfMountRepository.findByDescription("Dash");

        if(!dashUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM Not Found");
        }

        Optional<UnitOfMount> pintUomOptional = unitOfMountRepository.findByDescription("Pint");

        if(!pintUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM Not Found");
        }

        Optional<UnitOfMount> cupsUomOptional = unitOfMountRepository.findByDescription("Cup");

        if(!cupsUomOptional.isPresent()){
            throw new RuntimeException("Excepted UOM Not Found");
        }

        //get optionals
        UnitOfMount eachUom = eachUomOptional.get();
        UnitOfMount tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMount teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMount dashUom = dashUomOptional.get();
        UnitOfMount pintUom = pintUomOptional.get();
        UnitOfMount cupsUom = cupsUomOptional.get();

        //gets Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Excepted Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Excepted Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexianCategory = mexicanCategoryOptional.get();

        //Yummy Guac
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPreTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocado in half.Remove Seed.");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avacados");
        guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        guacRecipe.getIngredients().add(new Ingredient("ripe avocados",new BigDecimal("2"),eachUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Kosher salt",new BigDecimal("5"),tableSpoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Fresh lime or lemon juice",new BigDecimal("2"),tableSpoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion",new BigDecimal("2"),tableSpoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Serrano chills",new BigDecimal("2"),eachUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("Cilantro",new BigDecimal("2"),tableSpoonUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("freshly grated pepper",new BigDecimal("2"),dashUom,guacRecipe));
        guacRecipe.getIngredients().add(new Ingredient("ripe tomato",new BigDecimal("5"),eachUom,guacRecipe));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexianCategory);

        //add to return list
        recipes.add(guacRecipe);

        //Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPreTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high,direct heat:");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this:Everything goes better in a tortilla");

        tacoNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.getIngredients().add(new Ingredient("Anchor Chill Powder",new BigDecimal("2"),teaSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Oregano",new BigDecimal("1"),teaSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Dried Cumin",new BigDecimal("1"),teaSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Sugar",new BigDecimal("1"),teaSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Salt",new BigDecimal("5"),teaSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Clove of Garlic",new BigDecimal("1"),eachUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Finely grated orange",new BigDecimal("1"),tableSpoonUom,tacosRecipe));
        tacosRecipe.getIngredients().add(new Ingredient("Fresh-squeezed orange ",new BigDecimal("3"),tableSpoonUom,tacosRecipe));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexianCategory);

        recipes.add(tacosRecipe);

        System.out.println("My Recipes>>>>>>>"+recipes);

        return recipes;
     }


}
