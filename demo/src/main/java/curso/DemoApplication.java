package curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
	@Override
	public void run(String... args) throws Exception {
		System.out.println(puntua.damePunto());
		
	}

}
