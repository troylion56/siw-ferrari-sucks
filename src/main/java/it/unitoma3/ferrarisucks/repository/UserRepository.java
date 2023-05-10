package it.unitoma3.ferrarisucks.repository;

import org.springframework.data.repository.CrudRepository;

import it.unitoma3.ferrarisucks.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}