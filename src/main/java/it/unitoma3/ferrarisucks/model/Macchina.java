package it.unitoma3.ferrarisucks.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "macchine")
public class Macchina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "macchina_id")
    private Long macchinaId;

    @Column(name = "modello")
    private String modello;

    @ManyToMany(mappedBy = "macchine")
    private List<GranPremio> granPremi;

    public Long getMacchinaId() {
        return macchinaId;
    }

    public void setMacchinaId(Long macchinaId) {
        this.macchinaId = macchinaId;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public List<GranPremio> getGranPremi() {
        return granPremi;
    }

    public void setGranPremi(List<GranPremio> granPremi) {
        this.granPremi = granPremi;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((macchinaId == null) ? 0 : macchinaId.hashCode());
        result = prime * result + ((modello == null) ? 0 : modello.hashCode());
        result = prime * result + ((granPremi == null) ? 0 : granPremi.hashCode());
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
        if (macchinaId == null) {
            if (other.macchinaId != null)
                return false;
        } else if (!macchinaId.equals(other.macchinaId))
            return false;
        if (modello == null) {
            if (other.modello != null)
                return false;
        } else if (!modello.equals(other.modello))
            return false;
        if (granPremi == null) {
            if (other.granPremi != null)
                return false;
        } else if (!granPremi.equals(other.granPremi))
            return false;
        return true;
    }

    

    
    
}
