package curso;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Puntuacion {
	private String cad;
	
	private Punto p;

	@Autowired
	public Puntuacion(Punto p) {
		this.p = p;
		this.cad = p.toString();
	}
	
//	@PostConstruct
//	private void inicia() {
//		this.cad = p.toString();
//	}
	
	public String damePunto() {
		return cad;
	}

	public Punto getP() {
		return p;
	}

	public void setP(Punto p) {
		this.p = p;
	}
}
