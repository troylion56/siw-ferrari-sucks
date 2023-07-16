package it.unitoma3.ferrarisucks.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Commenti {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String author; 

    @NotBlank
    private String title;

    @NotBlank
    private String text;

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commenti commenti = (Commenti) o;
        return Objects.equals(id, commenti.id) && Objects.equals(author, commenti.author) && Objects.equals(title, commenti.title) && Objects.equals(text, commenti.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, text);
    }
}
