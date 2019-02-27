package curso;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import curso.dto.CountryDTO;
import curso.dto.FilmDTO;
import curso.dto.FilmListDTO;
import curso.model.Film;
import curso.repository.CountryRepository;
import curso.repository.FilmRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
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
	@Autowired
	private CountryRepository daoCountry;
	
	@Override @Transactional
	public void run(String... args) throws Exception {
//		for(FilmDTO item: dao.findTop5ByTitleStartingWith("A").stream()
//				.map(item->FilmDTO.form(item))
//				.collect(Collectors.toList()))
//			System.out.println(item.toString());
//		for(FilmListDTO item: dao.findTop5ByTitleStartingWith("B").stream()
//				.map(item->FilmListDTO.form(item))
//				.collect(Collectors.toList()))
//			System.out.println(item.toString());
//		ModelMapper modelMapper = new ModelMapper();
//		for(CountryDTO item: dao.findAll().stream()
//				.map(item->modelMapper.map(item, CountryDTO.class))
//				.collect(Collectors.toList()))
//			System.out.println(item.toString());
		//ObjectMapper objectMapper = new ObjectMapper();
		//System.out.println(objectMapper.writeValueAsString(FilmDTO.form(dao.getOne(1))));
		//System.out.println(objectMapper.writeValueAsString(dao.getOne(1)));
	}

}
