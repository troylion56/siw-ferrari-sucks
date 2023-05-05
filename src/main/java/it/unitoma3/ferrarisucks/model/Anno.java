package it.unitoma3.ferrarisucks.model;

import java.util.List;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Anno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int anno;

    @ManyToMany(mappedBy = "a")
    private List <GranPremio> gpp;

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public List<GranPremio> getGpp() {
        return gpp;
    }

    public void setGpp(List<GranPremio> gpp) {
        this.gpp = gpp;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + anno;
        result = prime * result + ((gpp == null) ? 0 : gpp.hashCode());
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
        Anno other = (Anno) obj;
        if (anno != other.anno)
            return false;
        if (gpp == null) {
            if (other.gpp != null)
                return false;
        } else if (!gpp.equals(other.gpp))
            return false;
        return true;
    }

    
}
