package corso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import corso.model.Indirizzo;
import corso.model.Persona;

public class DetachedTest {

	
	private EntityManagerFactory emf; 

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("gg1-proj1");
	}
	
	@Test
	public void test() {
		EntityManager em = emf.createEntityManager();
		Persona p = persona(1);
		
		p = em.find(Persona.class, p.getId());
		System.out.println(p.getAltezzaInCm());

		em.getTransaction().begin();
//		Session s = em.unwrap(Session.class);
//		s.update(p);
//		for(Indirizzo i : p.getAltriIndirizzi())
//			s.update(i);
		//em.refresh(p);
		p.setAltezzaInCm(p.getAltezzaInCm() + 1);
		em.getTransaction().commit();
		System.out.println(p.getCognome());
		
	}
	
	private Persona persona(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Persona p = em.find(Persona.class, id);
		p.setAltezzaInCm(p.getAltezzaInCm() + 1);
		em.getTransaction().commit();
//		em.close();
		return p;
	}

}
