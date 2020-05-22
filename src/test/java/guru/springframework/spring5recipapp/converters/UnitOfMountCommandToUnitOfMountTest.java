package guru.springframework.spring5recipapp.converters;

import guru.springframework.spring5recipapp.commands.UnitOfMountCommand;
import guru.springframework.spring5recipapp.domain.UnitOfMount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UnitOfMountCommandToUnitOfMountTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMountCommandToUnitOfMount converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMountCommandToUnitOfMount();

    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMountCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        UnitOfMountCommand command = new UnitOfMountCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMount uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());

    }

}