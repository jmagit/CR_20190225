package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
Usuarios, contraseña, roles
-----------------------------------
admin:admin []
user:password
disabled:password (this user is disabled)

Servicios
-----------------------------------
/auth - authentication endpoint with unrestricted access
	{
	    "username": "admin",
	    "password": "admin"
	}
/user - shows logged in user information  (a valid JWT token must be present in the request header)
/privado - restricted to authorized users
/admin - restricted to authorized users with the role 'ROLE_ADMIN'
 * 
 */
@SpringBootApplication
public class DemoJWTApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJWTApplication.class, args);
	}
}
