package curso;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import curso.dto.FilmDTO;
import curso.dto.FilmListDTO;
import curso.model.Film;
import curso.repository.FilmRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private Punto p;
	@Autowired
	private Punto p2;
	
	@Autowired
	@Qualifier("Old")
	private Saludar srv;
	
	@Value("${my.kk}")
	private String kk;
	
	@Autowired
	private Puntuacion puntua;
	
	@Autowired
	private FilmRepository dao;
	
	@Override
	public void run(String... args) throws Exception {
		for(FilmDTO item: dao.findByTitleStartingWith("A").stream()
				.map(item->FilmDTO.form(item))
				.collect(Collectors.toList()))
			System.out.println(item.getTitle());
		for(FilmListDTO item: dao.findByTitleStartingWith("B").stream()
				.map(item->FilmListDTO.form(item))
				.collect(Collectors.toList()))
			System.out.println(item.getTitle());
		
	}

}
