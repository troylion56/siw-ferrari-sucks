package it.unitoma3.ferrarisucks.siwferrarisucks.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Pilota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nome;
    String cognome;
    int numeroPilota;
    @ManyToMany(mappedBy = "p")
    private List<Macchina> mcc;
    

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCognome() {
        return cognome;
    }


    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public int getNumeroPilota() {
        return numeroPilota;
    }


    public void setNumeroPilota(int numeroPilota) {
        this.numeroPilota = numeroPilota;
    }


    public List<Macchina> getMcc() {
        return mcc;
    }


    public void setMcc(List<Macchina> mcc) {
        this.mcc = mcc;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
        result = prime * result + numeroPilota;
        result = prime * result + ((mcc == null) ? 0 : mcc.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pilota other = (Pilota) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.equals(other.cognome))
            return false;
        if (numeroPilota != other.numeroPilota)
            return false;
        if (mcc == null) {
            if (other.mcc != null)
                return false;
        } else if (!mcc.equals(other.mcc))
            return false;
        return true;
    }


}
