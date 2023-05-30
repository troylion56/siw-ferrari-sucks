package it.unitoma3.ferrarisucks.model;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "granpremi")
public class GranPremio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "granpremio_id")
    private Long granPremioId;

    @Column(name = "circuito")
    private String circuito;

    @Column(name = "data")
    private String data;

    @Column(name = "luogo")
    private String luogo;

    @ManyToMany
    @JoinTable(
            name = "granpremi_piloti",
            joinColumns = @JoinColumn(name = "granpremio_id"),
            inverseJoinColumns = @JoinColumn(name = "pilota_id")
    )
    private List<Pilota> piloti;

    @ManyToMany
    @JoinTable(
            name = "granpremi_macchine",
            joinColumns = @JoinColumn(name = "granpremio_id"),
            inverseJoinColumns = @JoinColumn(name = "macchina_id")
    )
    private List<Macchina> macchine;


    @ManyToMany
    @JoinTable(
            name = "granpremi_strategie",
            joinColumns = @JoinColumn(name = "granpremio_id"),
            inverseJoinColumns = @JoinColumn(name = "strategia_id")
    )
    private List<Strategia> strategie;


public Long getGranPremioId() {
        return granPremioId;
}


public void setGranPremioId(Long granPremioId) {
        this.granPremioId = granPremioId;
}


public String getCircuito() {
        return circuito;
}


public void setCircuito(String circuito) {
        this.circuito = circuito;
}


public String getData() {
        return data;
}


public void setData(String data) {
        this.data = data;
}


public String getLuogo() {
        return luogo;
}


public void setLuogo(String luogo) {
        this.luogo = luogo;
}


public List<Pilota> getPiloti() {
        return piloti;
}


public void setPiloti(List<Pilota> piloti) {
        this.piloti = piloti;
}


public List<Macchina> getMacchine() {
        return macchine;
}


public void setMacchine(List<Macchina> macchine) {
        this.macchine = macchine;
}


public List<Strategia> getStrategie() {
        return strategie;
}


public void setStrategie(List<Strategia> strategie) {
        this.strategie = strategie;
}


@Override
public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((granPremioId == null) ? 0 : granPremioId.hashCode());
        result = prime * result + ((circuito == null) ? 0 : circuito.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((luogo == null) ? 0 : luogo.hashCode());
        result = prime * result + ((piloti == null) ? 0 : piloti.hashCode());
        result = prime * result + ((macchine == null) ? 0 : macchine.hashCode());
        result = prime * result + ((strategie == null) ? 0 : strategie.hashCode());
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
        if (granPremioId == null) {
                if (other.granPremioId != null)
                        return false;
        } else if (!granPremioId.equals(other.granPremioId))
                return false;
        if (circuito == null) {
                if (other.circuito != null)
                        return false;
        } else if (!circuito.equals(other.circuito))
                return false;
        if (data == null) {
                if (other.data != null)
                        return false;
        } else if (!data.equals(other.data))
                return false;
        if (luogo == null) {
                if (other.luogo != null)
                        return false;
        } else if (!luogo.equals(other.luogo))
                return false;
        if (piloti == null) {
                if (other.piloti != null)
                        return false;
        } else if (!piloti.equals(other.piloti))
                return false;
        if (macchine == null) {
                if (other.macchine != null)
                        return false;
        } else if (!macchine.equals(other.macchine))
                return false;
        if (strategie == null) {
                if (other.strategie != null)
                        return false;
        } else if (!strategie.equals(other.strategie))
                return false;
        return true;
}
    
}
