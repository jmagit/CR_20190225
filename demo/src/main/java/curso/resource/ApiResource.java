package curso.resource;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class ApiResource {
	public class ApiDTO extends ResourceSupport {}
	@GetMapping("/api")
	public ApiDTO get() {
		ApiDTO rslt = new ApiDTO();
		rslt.add(linkTo(ApiResource.class).withSelfRel());
		rslt.add(linkTo(FilmResource.class).withRel("peliculas"));
		return rslt;
	}
}
