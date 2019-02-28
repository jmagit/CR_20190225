package curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import curso.dto.CustomerListProjection;
import curso.model.Customer;

@RepositoryRestResource(path="clientes", 
	itemResourceRel="cliente", collectionResourceRel="clientes"
//	, excerptProjection=CustomerListProjection.class
	)
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@RestResource(path = "por-nombre")
	List<Customer> findByFirstName(String nombre);
}
