package corso;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import corso.model.Persona;

public class JpaTest {
	
	private EntityManagerFactory emf; 
	
	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("gg1-proj1");
	}

	@Test
	public void test() {
		EntityManager em = emf.createEntityManager();

		List<Persona> persone = em.createQuery("select p from Persona p", Persona.class).getResultList();
		for(Persona p : persone) {
			System.out.println(p.getCognome());
		}
		Assert.assertTrue(persone.size() > 0);
		
		List<Integer> altezze = em.createQuery("select p.altezzaInCm from Persona p", Integer.class).getResultList();
		for(Integer p : altezze) {
			System.out.println(p);
		}
		
		persone = em.createQuery("select p from Persona p where p.altezzaInCm > 180", Persona.class).getResultList();
		for(Persona p : persone) {
			System.out.println(p.getCognome());
		}
		
		persone = em.createNamedQuery("persona.all", Persona.class).getResultList();
		for(Persona p : persone) {
			System.out.println(p.getCognome());
		}
		Assert.assertTrue(persone.size() > 0);
		
		persone = em.createNamedQuery("persona.piuAlteDi", Persona.class)
				.setParameter("altezza", 190)
				.getResultList();
		for(Persona p : persone) {
			System.out.println(p.getCognome());
		}
		Assert.assertTrue(persone.size() >= 0);
	}

}
