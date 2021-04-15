package corso.gg2proj1.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String via;
	private Integer civico;
	private String citta;
	private String pronvicia;
	
	//@OneToOne(mappedBy = "indirizzoPrincipale")
	@ManyToOne(cascade = {CascadeType.PERSIST})  // !! CascadeType.REMOVE ???
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public Integer getCivico() {
		return civico;
	}
	public void setCivico(Integer civico) {
		this.civico = civico;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getPronvicia() {
		return pronvicia;
	}
	public void setPronvicia(String pronvicia) {
		this.pronvicia = pronvicia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
