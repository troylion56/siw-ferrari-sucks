package it.unitoma3.ferrarisucks.repository;

import it.unitoma3.ferrarisucks.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    public boolean existsByEmail(String email);
}
