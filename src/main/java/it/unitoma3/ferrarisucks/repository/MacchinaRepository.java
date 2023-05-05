package it.unitoma3.ferrarisucks.repository;

import org.springframework.data.repository.CrudRepository;

import it.unitoma3.ferrarisucks.model.Macchina;

public interface MacchinaRepository extends CrudRepository<Macchina, Long> {
    
}
