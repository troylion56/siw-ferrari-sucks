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
@Table(name = "piloti")
public class Pilota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pilota_id")
    private Long pilotaId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "nazionalita")
    private String nazionalita;

    @ManyToMany(mappedBy = "piloti")
    private List<GranPremio> granPremi;

    public Long getPilotaId() {
        return pilotaId;
    }

    public void setPilotaId(Long pilotaId) {
        this.pilotaId = pilotaId;
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

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
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
        result = prime * result + ((pilotaId == null) ? 0 : pilotaId.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
        result = prime * result + ((nazionalita == null) ? 0 : nazionalita.hashCode());
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
        Pilota other = (Pilota) obj;
        if (pilotaId == null) {
            if (other.pilotaId != null)
                return false;
        } else if (!pilotaId.equals(other.pilotaId))
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
        if (nazionalita == null) {
            if (other.nazionalita != null)
                return false;
        } else if (!nazionalita.equals(other.nazionalita))
            return false;
        if (granPremi == null) {
            if (other.granPremi != null)
                return false;
        } else if (!granPremi.equals(other.granPremi))
            return false;
        return true;
    }

    
}
