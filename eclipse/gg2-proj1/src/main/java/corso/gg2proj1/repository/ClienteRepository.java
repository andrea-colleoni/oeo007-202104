package corso.gg2proj1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.gg2proj1.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
