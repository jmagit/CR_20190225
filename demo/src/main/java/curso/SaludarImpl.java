package curso;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("Old")
public class SaludarImpl implements Saludar {

	@Override
	public String saludar() {
		return "Hola mundo";
	}

}
