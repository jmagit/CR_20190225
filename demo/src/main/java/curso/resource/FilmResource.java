package curso.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.loading.PrivateClassLoader;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import curso.dto.FilmDTO;
import curso.model.Film;
import curso.repository.FilmRepository;
import curso.resource.exception.BadRequestException;
import curso.resource.exception.NotFoundException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping(path="/pelis")
public class FilmResource {
	@Autowired
	private FilmRepository dao;
	@Autowired
	private Validator validator;
	
	@GetMapping
	public List<FilmDTO> getAll() {
		return dao.findAll().stream()
		.map(item->FilmDTO.form(item))
		.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public FilmDTO getOne(@PathVariable int id) throws NotFoundException {
		Optional<Film> rslt = dao.findById(id);
		if(!rslt.isPresent())
			throw new NotFoundException();
		FilmDTO item = FilmDTO.form(rslt.get());
		item.add(linkTo(FilmResource.class).slash(id).withSelfRel());
		item.add(linkTo(FilmResource.class).slash(1).withRel("first"));
		item.add(linkTo(FilmResource.class).slash(id).slash("actores").withRel("actores"));
		item.add(linkTo(FilmResource.class).slash(id).slash("category").withRel("categorias"));
		return item;
	}

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody FilmDTO item) throws BadRequestException {
		Film newItem = FilmDTO.form(item);
		Set<ConstraintViolation<@Valid Film>> constraintViolations =  
				validator.validate( newItem );
		if(constraintViolations.size() > 0)
			throw new BadRequestException("Errores de validación");
		Optional<Film> rslt = dao.findById(item.getIdFilm());
		if(rslt.isPresent())
			throw new BadRequestException("Elemento duplicado");
		dao.save(newItem);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(newItem.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PutMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void update(@PathVariable int id, @Valid @RequestBody FilmDTO item) throws BadRequestException, NotFoundException {
		if (id != item.getIdFilm())
			throw new BadRequestException("Bad identifier");
		Optional<Film> rslt = dao.findById(item.getIdFilm());
		if(!rslt.isPresent())
			throw new NotFoundException();
		Film newItem = FilmDTO.form(item);
		Set<ConstraintViolation<@Valid Film>> constraintViolations =  
				validator.validate( newItem );
		if(constraintViolations.size() > 0)
			throw new BadRequestException("Errores de validación");
		dao.save(newItem);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) throws BadRequestException, NotFoundException {
		Optional<Film> rslt = dao.findById(id);
		if(!rslt.isPresent())
			throw new NotFoundException();
		dao.deleteById(id);
	}

	@GetMapping("/{id}/actores")
	public FilmDTO getAllActores(@PathVariable int id) throws NotFoundException {
		Optional<Film> rslt = dao.findById(id);
		if(!rslt.isPresent())
			throw new NotFoundException();
		return FilmDTO.form(rslt.get());
	}

}




