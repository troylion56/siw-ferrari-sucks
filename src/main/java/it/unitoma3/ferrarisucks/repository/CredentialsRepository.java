package it.unitoma3.ferrarisucks.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.unitoma3.ferrarisucks.model.Credentials;

public interface CredentialsRepository extends CrudRepository<Credentials, Long> {

	public Optional<Credentials> findByEmail(String email);

}