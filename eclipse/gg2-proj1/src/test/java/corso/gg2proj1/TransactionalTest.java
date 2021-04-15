package corso.gg2proj1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import corso.gg2proj1.model.Persona;
import corso.gg2proj1.repository.PersonaRepository;

@SpringBootTest
class TransactionalTest {
	
	@Autowired
	private PersonaRepository repo;
	
	@Autowired
	private PlatformTransactionManager tx;

	@Test
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	void test() {
		//assertFalse(TransactionSynchronizationManager.isActualTransactionActive());
		
		Persona p = new Persona();
		p.setId(100);
		p.setAttivo(true);
		p.setCognome("chiamante");
		
		chiamato(200);
		
		repo.save(p);
		System.out.println(tx.toString() + " # " + TransactionSynchronizationManager.getCurrentTransactionName());
		
		chiamato(300);
		//tx.commit(TransactionAspectSupport.currentTransactionStatus());
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void chiamato(Integer id) {

		Persona p = new Persona();
		p.setId(id);
		p.setAttivo(true);
		p.setCognome("chiamato");
		
		repo.save(p);
		System.out.println(tx.toString() + " # " + TransactionSynchronizationManager.getCurrentTransactionName());
	}

}
