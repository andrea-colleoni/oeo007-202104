package corso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

import corso.model.Persona;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gg1-proj1");
		
		EntityManager em = emf.createEntityManager();
		
		// CRUD
		// se modifico i dati nel DB devo farlo in un TX
		
		
		// hibernate session dall'entitymanager
		
		Session s = em.unwrap(Session.class);
		
		// DELETE

		// modo 1
//		Persona p3 = em.find(Persona.class, "RSSMRA87654321");
//		em.getTransaction().begin();
//		em.remove(p3);
//		em.getTransaction().commit();
		
		// modo 2
//		Persona p4 = new Persona();
//		p4.setCodiceFiscale("RSSMRA99999");
//		em.merge(p4);
		
		Persona p4 = em.getReference(Persona.class, "RSSMRA99999");
		System.out.println(p4.getNome());
		em.getTransaction().begin();

		em.remove(p4);
		em.getTransaction().commit();
		
		
		/* FIND  (SELECT ONE) */

		// Persona p1 = em.find(Persona.class, "RSSMRA12345678");
//		Persona p2 = em.find(Persona.class, "RSSMRA87654321");
////		if (p1 != null) {
////			System.out.println(p1.getCognome());
////		}
//		
//		System.out.println(p2.getCognome());
//		em.detach(p2);
//		
//		// esempio di merge() 
//		Persona p1 = new Persona(); // nuovo oggetto
//		p1.setCodiceFiscale("RSSMRA99999");
//		p1.setNome("Luigi");
//		
////		Persona p1 = em.find(Persona.class, "RSSMRA12345678");
////		em.detach(p1);
////		em.persist(p1);
//		
//		em.merge(p1);
//		
//		//em.merge(p1);
//		System.out.println(p1.getCognome());
//		
//		/* UPDATE */	
//		em.getTransaction().begin();
//		p1.setAltezzaInCm(185);
//		p2.setAltezzaInCm(178);
//		em.getTransaction().commit();
//		
//
//		/* INSERT */
//		/*
//		p = new Persona(); // nuovo oggetto
//		p.setNome("Mario");
//		p.setCognome("Rossi");
//		p.setCodiceFiscale("RSSMRA87654321");
//
//		//em.getTransaction().begin();
//		
//		em.persist(p);
//		
//		//em.getTransaction().commit(); // salvo le op sul DB
//		// em.getTransaction().rollback(); // annullo le operazioni fatte
//		
//		em.close();
//		*/

	}

}
