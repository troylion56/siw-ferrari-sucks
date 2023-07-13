package it.unitoma3.ferrarisucks.model;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Macchina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modello;

    @Min(1950)
    @Max(2023)
    private Integer anno;

    @OneToMany(mappedBy="macchina")
	private List<Strategia> macchinaInstrategia;

    @OneToOne
    private Image immagineMaccchina;

    public Macchina(){
        this.macchinaInstrategia= new LinkedList<>();
    }

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

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public List<Strategia> getMacchinaInstrategia() {
        return macchinaInstrategia;
    }

    public void setMacchinaInstrategia(List<Strategia> macchinaInstrategia) {
        this.macchinaInstrategia = macchinaInstrategia;
    }

    public Image getImmagineMaccchina() {
        return immagineMaccchina;
    }

    public void setImmagineMaccchina(Image immagineMaccchina) {
        this.immagineMaccchina = immagineMaccchina;
    }


    @Override
	public int hashCode() {
		return Objects.hash(modello, anno);
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
		return Objects.equals(modello, other.modello) && anno==other.anno ;
	}
}
