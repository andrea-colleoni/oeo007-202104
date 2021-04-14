package corso.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
	
	// deve essere un JavaBean
	// deve essere annotata con @Entity
	// deve avere una PK => @Id
	// deve essere elencata in persistence.xml
	
	@Id
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private int altezzaInCm;
	
	
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
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public int getAltezzaInCm() {
		return altezzaInCm;
	}
	public void setAltezzaInCm(int altezzaInCm) {
		this.altezzaInCm = altezzaInCm;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	

}
