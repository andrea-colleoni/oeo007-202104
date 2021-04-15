package corso.gg2proj1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import corso.gg2proj1.model.Persona;

@SpringBootTest
public class EMFTest {
	
	@Autowired
	private EntityManagerFactory emf;
	
	@Test
	public void test() {
		EntityManager em = emf.createEntityManager();
		Persona p = em.find(Persona.class, 1);
		System.out.println(p.getCognome());
	}

}
