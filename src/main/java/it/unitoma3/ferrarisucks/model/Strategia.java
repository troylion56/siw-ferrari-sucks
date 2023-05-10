package it.unitoma3.ferrarisucks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Strategia {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String Descrizione;

    @ManyToOne       //applicata 
    private Macchina macchina;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public Macchina getMacchina() {
        return macchina;
    }

    public void setMacchina(Macchina macchina) {
        this.macchina = macchina;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((Descrizione == null) ? 0 : Descrizione.hashCode());
        result = prime * result + ((macchina == null) ? 0 : macchina.hashCode());
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
        Strategia other = (Strategia) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (Descrizione == null) {
            if (other.Descrizione != null)
                return false;
        } else if (!Descrizione.equals(other.Descrizione))
            return false;
        if (macchina == null) {
            if (other.macchina != null)
                return false;
        } else if (!macchina.equals(other.macchina))
            return false;
        return true;
    }
    
}
