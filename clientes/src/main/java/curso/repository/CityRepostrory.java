package curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import curso.model.City;

@RepositoryRestResource(path="ciudades", itemResourceRel="ciudad", collectionResourceRel="ciudades")
public interface CityRepostrory extends JpaRepository<City, Integer> {

}
