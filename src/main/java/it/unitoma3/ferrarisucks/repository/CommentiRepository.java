package it.unitoma3.ferrarisucks.repository;

import org.springframework.data.repository.CrudRepository;

import it.unitoma3.ferrarisucks.model.Commenti;

public interface CommentiRepository extends CrudRepository<Commenti,Long>{


    public boolean existsByAuthorAndTitleAndText(String author, String title, String text);

}
