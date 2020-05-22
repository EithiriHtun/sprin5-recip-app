package guru.springframework.spring5recipapp.converters;

import guru.springframework.spring5recipapp.commands.UnitOfMountCommand;
import guru.springframework.spring5recipapp.domain.UnitOfMount;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class UnitOfMountoUnitOfMountCommand implements Converter<UnitOfMount, UnitOfMountCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMountCommand convert(UnitOfMount unitOfMount) {

        if (unitOfMount != null) {
            final UnitOfMountCommand uomc = new UnitOfMountCommand();
            uomc.setId(unitOfMount.getId());
            uomc.setDescription(unitOfMount.getDescription());
            return uomc;
        }
        return null;
    }
}
