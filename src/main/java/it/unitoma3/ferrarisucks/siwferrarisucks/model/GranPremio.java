package it.unitoma3.ferrarisucks.siwferrarisucks.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class GranPremio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nomeCircuito;
    String nazioneDoveCorsa;

    @ManyToMany(mappedBy = "gp")
    private List<Macchina> mc; 


    @ManyToMany
    private List <Anno> a;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNomeCircuito() {
        return nomeCircuito;
    }


    public void setNomeCircuito(String nomeCircuito) {
        this.nomeCircuito = nomeCircuito;
    }


    public String getNazioneDoveCorsa() {
        return nazioneDoveCorsa;
    }


    public void setNazioneDoveCorsa(String nazioneDoveCorsa) {
        this.nazioneDoveCorsa = nazioneDoveCorsa;
    }


    public List<Macchina> getMc() {
        return mc;
    }


    public void setMc(List<Macchina> mc) {
        this.mc = mc;
    }


    public List<Anno> getA() {
        return a;
    }


    public void setA(List<Anno> a) {
        this.a = a;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nomeCircuito == null) ? 0 : nomeCircuito.hashCode());
        result = prime * result + ((nazioneDoveCorsa == null) ? 0 : nazioneDoveCorsa.hashCode());
        result = prime * result + ((mc == null) ? 0 : mc.hashCode());
        result = prime * result + ((a == null) ? 0 : a.hashCode());
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
        GranPremio other = (GranPremio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nomeCircuito == null) {
            if (other.nomeCircuito != null)
                return false;
        } else if (!nomeCircuito.equals(other.nomeCircuito))
            return false;
        if (nazioneDoveCorsa == null) {
            if (other.nazioneDoveCorsa != null)
                return false;
        } else if (!nazioneDoveCorsa.equals(other.nazioneDoveCorsa))
            return false;
        if (mc == null) {
            if (other.mc != null)
                return false;
        } else if (!mc.equals(other.mc))
            return false;
        if (a == null) {
            if (other.a != null)
                return false;
        } else if (!a.equals(other.a))
            return false;
        return true;
    }
    
}
