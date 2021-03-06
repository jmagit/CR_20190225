package curso;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class AppConfig {
	@Bean public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Configuration
	public class SwaggerConfiguration {
		@Bean
		public Docket api() {                
		    return new Docket(DocumentationType.SWAGGER_2)          
		      .select()
		      .apis(RequestHandlerSelectors.basePackage("curso.resource"))
		      .paths(PathSelectors.ant("/**"))
		      .build()
		      .apiInfo(new ApiInfoBuilder()
		                .title("Mis microservicios")
		                .version("1.0")
		                .license("Apache License Version 2.0")
		                .contact(new Contact("Yo Mismo", "http://www.example.com", "myeaddress@example.com"))
		                .build());
		}
	}

}
