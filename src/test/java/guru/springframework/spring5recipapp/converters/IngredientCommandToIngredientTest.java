package guru.springframework.spring5recipapp.converters;


import guru.springframework.spring5recipapp.commands.IngredientCommand;
import guru.springframework.spring5recipapp.commands.UnitOfMountCommand;
import guru.springframework.spring5recipapp.domain.Ingredient;
import guru.springframework.spring5recipapp.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class IngredientCommandToIngredientTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long ID_VALUE = new Long(1L);
    public static final Long UOM_ID = new Long(2L);

    IngredientCommandToIngredient converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientCommandToIngredient(new UnitOfMountCommandToUnitOfMount());
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new IngredientCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMountCommand unitOfMountCommand = new UnitOfMountCommand();
        unitOfMountCommand.setId(UOM_ID);
        command.setUom(unitOfMountCommand);

        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    @Test
    public void convertWithNullUOM() throws Exception {
        //given
        IngredientCommand command = new IngredientCommand();
        command.setId(ID_VALUE);
        command.setAmount(AMOUNT);
        command.setDescription(DESCRIPTION);
        UnitOfMountCommand unitOfMountCommand = new UnitOfMountCommand();


        //when
        Ingredient ingredient = converter.convert(command);

        //then
        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
    }

}