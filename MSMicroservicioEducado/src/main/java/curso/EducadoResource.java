package curso;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducadoResource {
	@GetMapping("/saludo")
	public String saludo() {
		return "Hola Mundo";
	}
	@GetMapping("/saludo/{nombre}")
	public String saluda(@PathVariable String nombre) {
		return "Hola " + nombre;
	}
}
