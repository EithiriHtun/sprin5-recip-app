package guru.springframework.spring5recipapp.controller;

import guru.springframework.spring5recipapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    /*private CategoryRepository categoryRepository;
    private UnitOfMountRepository unitOfMountRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMountRepository unitOfMountRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMountRepository = unitOfMountRepository;
    }*/

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","index"})
    public String getIndexPage(Model model){

        log.debug("Getting Index Page..");

        System.out.println("My Recipes in controller>>>>>>>"+recipeService.getRecipes());

        model.addAttribute("recipes",recipeService.getRecipes());

        /*Optional<Category> optionalCategory = categoryRepository.findByDescription("American");

        Optional<UnitOfMount> optionalUnitOfMount = unitOfMountRepository.findByDescription("Teaspoon");

        System.out.println("Some message to says!!!..123433");

        System.out.println("Cat ID is:" + optionalCategory.get().getId());

        System.out.println("UOM ID is:"+ optionalUnitOfMount.get().getId());*/

        System.out.println("Some message to says!!!.."+recipeService.getRecipes());

        return "index";
    }

}
