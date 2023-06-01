package it.unitoma3.ferrarisucks.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "strategie")
public class Strategia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "strategia_id")
    private Long strategiaId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descrizione")
    private String descrizione;

    @ManyToMany(mappedBy = "strategie")
    private List<GranPremio> granPremi;

    @ManyToOne
    private User creatore;

    public Long getStrategiaId() {
        return strategiaId;
    }

    public void setStrategiaId(Long strategiaId) {
        this.strategiaId = strategiaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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
        result = prime * result + ((strategiaId == null) ? 0 : strategiaId.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
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
        Strategia other = (Strategia) obj;
        if (strategiaId == null) {
            if (other.strategiaId != null)
                return false;
        } else if (!strategiaId.equals(other.strategiaId))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (descrizione == null) {
            if (other.descrizione != null)
                return false;
        } else if (!descrizione.equals(other.descrizione))
            return false;
        if (granPremi == null) {
            if (other.granPremi != null)
                return false;
        } else if (!granPremi.equals(other.granPremi))
            return false;
        return true;
    }

    
}