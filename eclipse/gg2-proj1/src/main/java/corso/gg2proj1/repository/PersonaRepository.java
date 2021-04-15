package corso.gg2proj1.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import corso.gg2proj1.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	Optional<Persona> findByCognome(String cognome);
	
	Stream<Persona> streamByAltezzaInCmGreaterThan(Integer altezza);
	
	//@Query(nativeQuery = true, value = "select p from Persona p where altezzaInCm > :altezza")
	@Query(value = "select p from Persona p where altezzaInCm > :altezza")
	@QueryHints({
		@QueryHint(name = "READ_ONLY", value = "true") // hanno effetto sul DB
	})
	List<Persona> elencoByAltezzaInCm(Integer altezza);
	
	
}
