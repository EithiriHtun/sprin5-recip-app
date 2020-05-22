package guru.springframework.spring5recipapp.services;


import guru.springframework.spring5recipapp.commands.UnitOfMountCommand;
import guru.springframework.spring5recipapp.converters.UnitOfMountoUnitOfMountCommand;
import guru.springframework.spring5recipapp.repositories.UnitOfMountRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UnitOfMountServiceImpl implements UnitOfMountService {

    private final UnitOfMountRepository unitOfMountRepository;
    private final UnitOfMountoUnitOfMountCommand unitOfMountoUnitOfMountCommand;

    public UnitOfMountServiceImpl(UnitOfMountRepository unitOfMountRepository, UnitOfMountoUnitOfMountCommand unitOfMountoUnitOfMountCommand) {
        this.unitOfMountRepository = unitOfMountRepository;
        this.unitOfMountoUnitOfMountCommand = unitOfMountoUnitOfMountCommand;
    }

    @Override
    public Set<UnitOfMountCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMountRepository.findAll()
                .spliterator(), false)
                .map(unitOfMountoUnitOfMountCommand::convert)
                .collect(Collectors.toSet());
    }
}
