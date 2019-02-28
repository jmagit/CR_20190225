package curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import curso.model.Address;

@RepositoryRestResource(path="direcciones", itemResourceRel="direccion", collectionResourceRel="direcciones")
public interface AddressRepostrory extends JpaRepository<Address, Integer> {

}
