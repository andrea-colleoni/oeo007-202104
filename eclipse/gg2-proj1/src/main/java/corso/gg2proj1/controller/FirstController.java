package corso.gg2proj1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.gg2proj1.model.Persona;
import corso.gg2proj1.repository.PersonaRepository;

@RestController
public class FirstController {

	@Autowired
	private PersonaRepository repo;
	
	@GetMapping("/api/persone")
	public List<Persona> persone() {
		return repo.findAll();
	}
	
	@PostMapping("/api/persone/{xxx}")
	public List<Persona> personePost(@PathVariable String xxx, String test) {
		return repo.findAll();
	}
	
}
