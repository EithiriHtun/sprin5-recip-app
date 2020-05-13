package guru.springframework.spring5recipapp.domain;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    public void Setup(){
    category = new Category();
    }

    @Test
    void getId() throws Exception {
        System.out.println("ID is >>>" );
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue,category.getId());
    }

    @Test
    void getDescription() throws Exception {
    }

    @Test
    void getRecipes() throws Exception {
    }
}