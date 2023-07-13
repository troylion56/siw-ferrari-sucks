package it.unitoma3.ferrarisucks.repository;

import it.unitoma3.ferrarisucks.model.Credentials;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CredentialsRepository extends CrudRepository<Credentials,Long> {
    public Optional<Credentials> findByUsername(String username);

    public boolean existsByUsername(String username);
}
