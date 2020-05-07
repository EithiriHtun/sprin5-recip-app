package guru.springframework.spring5recipapp.repositories;

import guru.springframework.spring5recipapp.domain.UnitOfMount;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMountRepository extends CrudRepository<UnitOfMount, Long> {

    Optional<UnitOfMount> findByDescription(String description);

}
