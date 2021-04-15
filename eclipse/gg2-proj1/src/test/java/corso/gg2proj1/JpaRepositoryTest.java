package corso.gg2proj1;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import corso.gg2proj1.model.Persona;
import corso.gg2proj1.repository.PersonaRepository;

@SpringBootTest
public class JpaRepositoryTest {

	@Autowired
	private PersonaRepository persone;
	
	@Test
	@Transactional
	public void firstJpaTests() {
		persone.findById(1).ifPresent(p -> System.out.println(p.getCognome()));
		
//		persone.findByCognome("rossi")
//			.stream()
//			.forEach(p -> System.out.println(p.getCodiceFiscale()));
		
		persone.findByCognome("rossi").ifPresent(p -> System.out.println(p.getCodiceFiscale()));
		
		persone.streamByAltezzaInCmGreaterThan(160).forEach(p -> System.out.println(p.getAltezzaInCm()));
		

		List<Persona> pers = persone.elencoByAltezzaInCm(160);
		for(Persona p : pers)
			System.out.println(p.getAltezzaInCm());
	}
}
