package guru.springframework.spring5recipapp.converters;

import guru.springframework.spring5recipapp.commands.UnitOfMeasureCommand;
import guru.springframework.spring5recipapp.domain.UnitOfMount;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 6/21/17.
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMount> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMount convert(UnitOfMeasureCommand source) {
        if (source == null) {
            return null;
        }

        final UnitOfMount uom = new UnitOfMount();
        uom.setId(source.getId());
        uom.setDescription(source.getDescription());
        return uom;
    }
}
