package corso.gg2proj1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import corso.gg2proj1.model.Cliente;
import corso.gg2proj1.model.Persona;
import corso.gg2proj1.repository.ClienteRepository;
import corso.gg2proj1.repository.PersonaRepository;

@SpringBootTest
public class EreditarietaTest {
	
	@Autowired
	private PersonaRepository pRepo;
	
	@Autowired
	private ClienteRepository cRepo;
	
	@Test
	public void testEred() {
		Cliente c = new Cliente();
		
		c.setCodiceFiscale("123456");
		c.setRagioneSociale("abc spa");
		c.setCognome("verdi");
		c.setAttivo(true);
		c.setId(1);
		
		Persona p = new Persona();
		p.setCognome("rossi");
		p.setAttivo(false);
		p.setId(2);
		
		pRepo.save(p);
		pRepo.save(c);
		
		System.out.println("***********");
		cRepo.findAll().stream().forEach(cl -> System.out.println(cl.getCognome()));
		System.out.println("***********");		
		pRepo.findAll().stream().forEach(pe -> System.out.println(pe.getCognome()));
		
	}

}
