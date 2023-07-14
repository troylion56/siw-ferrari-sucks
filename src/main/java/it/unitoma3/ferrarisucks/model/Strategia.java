package it.unitoma3.ferrarisucks.model;

import java.util.Set;

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

    @NotBlank
    private String descrizione;

    @OneToOne
    Image image; 

    @ManyToOne
    private Macchina macchina;

    @OneToMany
    private Set<Commenti> reviews;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }
   
    public String getCircuito() {
        return circuito;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Macchina getMacchina() {
        return macchina;
    }

    public void setMacchina(Macchina macchina) {
        this.macchina = macchina;
    }

    public Set<Commenti> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Commenti> reviews) {
        this.reviews = reviews;
    }


   

    

    


    
}
