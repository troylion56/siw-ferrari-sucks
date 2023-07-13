package it.unitoma3.ferrarisucks.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Strategia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String circuito;

    @OneToOne
    Image image;

    @ManyToOne
    private Macchina macchina;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.nome = title;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return nome;
    }

    public String getCircuito() {
        return circuito;
    }

    public Image getImage() {
        return image;
    }
}
