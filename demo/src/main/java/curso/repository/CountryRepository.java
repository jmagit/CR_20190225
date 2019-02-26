package curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
