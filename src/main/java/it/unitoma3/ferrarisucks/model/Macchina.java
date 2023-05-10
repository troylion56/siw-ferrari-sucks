package it.unitoma3.ferrarisucks.model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Macchina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    String modello;


    @OneToMany(mappedBy = "macchina")
    private List<Strategia> strategie;

    @ManyToMany     //corre
    private List<GranPremio> gp;

    @ManyToMany        //guidata da
    private List <Pilota> p;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public List<Strategia> getStrategie() {
        return strategie;
    }

    public void setStrategie(List<Strategia> strategie) {
        this.strategie = strategie;
    }

    public List<GranPremio> getGp() {
        return gp;
    }

    public void setGp(List<GranPremio> gp) {
        this.gp = gp;
    }

    public List<Pilota> getP() {
        return p;
    }

    public void setP(List<Pilota> p) {
        this.p = p;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((modello == null) ? 0 : modello.hashCode());
        result = prime * result + ((strategie == null) ? 0 : strategie.hashCode());
        result = prime * result + ((gp == null) ? 0 : gp.hashCode());
        result = prime * result + ((p == null) ? 0 : p.hashCode());
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
        Macchina other = (Macchina) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (modello == null) {
            if (other.modello != null)
                return false;
        } else if (!modello.equals(other.modello))
            return false;
        if (strategie == null) {
            if (other.strategie != null)
                return false;
        } else if (!strategie.equals(other.strategie))
            return false;
        if (gp == null) {
            if (other.gp != null)
                return false;
        } else if (!gp.equals(other.gp))
            return false;
        if (p == null) {
            if (other.p != null)
                return false;
        } else if (!p.equals(other.p))
            return false;
        return true;
    }
    
    
    
}
