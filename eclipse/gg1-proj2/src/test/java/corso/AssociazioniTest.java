package corso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import corso.model.Indirizzo;
import corso.model.Persona;

public class AssociazioniTest {
	
	private EntityManagerFactory emf; 

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("gg1-proj1");
	}

	@Test
	public void test() {
		EntityManager em = emf.createEntityManager();

//		List<Indirizzo> indirizzi = em.createQuery("select i from Indirizzo i where i.persona.altezzaInCm > 180", Indirizzo.class).getResultList();
//		for(Indirizzo i : indirizzi) {
//			System.out.println(i.getPronvicia());
//		}
//		Assert.assertTrue(indirizzi.size() > 0);
		
		Persona p = new Persona();
		p.setCognome("Abcd");
		p.setAttivo(true);
		
		Indirizzo i1 = new Indirizzo();
		i1.setPronvicia("Venezia");
		
		//p.addIndirizzo(i1);
		i1.setPersona(p);
		
		Indirizzo i2 = new Indirizzo();
		i2.setPronvicia("Bari");
		
		//p.addIndirizzo(i2);
		i2.setPersona(p);
		
		em.getTransaction().begin();
		
		//em.persist(p);
		em.persist(i1);
		em.persist(i2);
		
		em.getTransaction().commit();
	}

}
