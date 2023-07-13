package it.unitoma3.ferrarisucks.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import it.unitoma3.ferrarisucks.model.Strategia;


public interface StrategiaRepository extends CrudRepository<Strategia, Long>{
    public List <Strategia> findByCircuito(String nome);

    public boolean existsByNomeAndCircuito(String nome, String circuito);
}
