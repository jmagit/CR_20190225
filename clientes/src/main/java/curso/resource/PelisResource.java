package curso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import curso.dto.FilmDTO;

@RestController
@RequestMapping(path="/pelis")
public class PelisResource {
	@Autowired RestTemplate srvRest;
	
	@GetMapping
	public List<FilmDTO> damePelis() {
		ResponseEntity<List<FilmDTO>> response = 
				srvRest.exchange("http://localhost:5555/pelis", 
						HttpMethod.GET,
				HttpEntity.EMPTY, 
				new ParameterizedTypeReference<List<FilmDTO>>() {
				});
		return response.getBody();
	}
}
