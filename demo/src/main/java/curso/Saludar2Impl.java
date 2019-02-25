package curso;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("New")
public class Saludar2Impl implements Saludar {

	@Override
	public String saludar() {
		return "Hola mundo".toUpperCase();
	}

}
