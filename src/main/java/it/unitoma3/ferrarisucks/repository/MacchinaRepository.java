package it.unitoma3.ferrarisucks.repository;

import org.springframework.data.repository.CrudRepository;
import it.unitoma3.ferrarisucks.model.Macchina;
import it.unitoma3.ferrarisucks.model.Strategia;


public interface MacchinaRepository extends CrudRepository<Macchina, Long> {

    public boolean existsByModelloAndAnno(String modello, Integer anno);

    public Strategia findAllById(Long id);
}


