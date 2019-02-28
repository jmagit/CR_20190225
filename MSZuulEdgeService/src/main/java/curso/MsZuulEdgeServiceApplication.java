package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MsZuulEdgeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsZuulEdgeServiceApplication.class, args);
	}
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

}
