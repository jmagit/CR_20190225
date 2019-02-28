package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsMicroservicioEducadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMicroservicioEducadoApplication.class, args);
	}

}
