package guru.springframework.spring5recipapp.services;


import guru.springframework.spring5recipapp.commands.UnitOfMountCommand;
import guru.springframework.spring5recipapp.converters.UnitOfMountoUnitOfMountCommand;
import guru.springframework.spring5recipapp.domain.UnitOfMount;
import guru.springframework.spring5recipapp.repositories.UnitOfMountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UnitOfMountServiceImplTest {

    UnitOfMountoUnitOfMountCommand unitOfMountoUnitOfMountCommand = new UnitOfMountoUnitOfMountCommand();
    UnitOfMountService service;

    @Mock
    UnitOfMountRepository unitOfMountRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service = new UnitOfMountServiceImpl(unitOfMountRepository, unitOfMountoUnitOfMountCommand);
    }

    @Test
    public void listAllUoms() throws Exception {
        //given
        Set<UnitOfMount> unitOfMeasures = new HashSet<>();
        UnitOfMount uom1 = new UnitOfMount();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMount uom2 = new UnitOfMount();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

        when(unitOfMountRepository.findAll()).thenReturn(unitOfMeasures);

        //when
        Set<UnitOfMountCommand> commands = service.listAllUoms();

        //then
        assertEquals(2, commands.size());
        verify(unitOfMountRepository, times(1)).findAll();
    }

}