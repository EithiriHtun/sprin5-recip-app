package guru.springframework.spring5recipapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMountCommand {
    private Long id;
    private String description;
}
