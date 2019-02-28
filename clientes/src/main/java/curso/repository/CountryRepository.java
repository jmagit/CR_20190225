package curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import curso.model.Country;

@RepositoryRestResource(path="paises", itemResourceRel="pais", collectionResourceRel="paises")
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
}
