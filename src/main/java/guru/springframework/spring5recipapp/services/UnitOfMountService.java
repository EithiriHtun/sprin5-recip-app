package guru.springframework.spring5recipapp.services;

import guru.springframework.spring5recipapp.commands.UnitOfMountCommand;

import java.util.Set;

public interface UnitOfMountService {

    Set<UnitOfMountCommand> listAllUoms();
}
