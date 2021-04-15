package corso.gg2proj1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "tipo_persona")
//@Table(name = "pers_001")
@NamedQueries({
	@NamedQuery(name = "persona.all", query = "select p from Persona p"),
	@NamedQuery(name = "persona.piuAlteDi", query = "select p from Persona p where p.altezzaInCm > :altezza")
})
public class Persona {
	
	// deve essere un JavaBean
	// deve essere annotata con @Entity
	// deve avere una PK => @Id
	// deve essere elencata in persistence.xml
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "codfisc", length = 20)
	private String codiceFiscale;
	@Column(length = 40)
	private String nome;
	@Column(length = 40)
	private String cognome;
	@Column(name = "data_n")
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	@Column(name = "altezza_cm")
	private Integer altezzaInCm;
	@Column(columnDefinition = "bit not null default false")
	private Boolean attivo;
	
//	@OneToOne
//	private Indirizzo indirizzoPrincipale;
	@OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	private List<Indirizzo> altriIndirizzi; // = new ArrayList<Indirizzo>();
	
	public void addIndirizzo(Indirizzo i) {
		if (altriIndirizzi == null)
			altriIndirizzi = new ArrayList<Indirizzo>();
		
		altriIndirizzi.add(i);
		i.setPersona(this);
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
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public Integer getAltezzaInCm() {
		return altezzaInCm;
	}
	public void setAltezzaInCm(Integer altezzaInCm) {
		this.altezzaInCm = altezzaInCm;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getAttivo() {
		return attivo;
	}
	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}
//	public Indirizzo getIndirizzoPrincipale() {
//		return indirizzoPrincipale;
//	}
//	public void setIndirizzoPrincipale(Indirizzo indirizzoPrincipale) {
//		this.indirizzoPrincipale = indirizzoPrincipale;
//	}
	public List<Indirizzo> getAltriIndirizzi() {
		return altriIndirizzi;
	}
	public void setAltriIndirizzi(List<Indirizzo> altriIndirizzi) {
		this.altriIndirizzi = altriIndirizzi;
	}
}
