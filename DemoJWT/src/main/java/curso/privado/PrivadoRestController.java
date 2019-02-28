package curso.privado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/privado")
public class PrivadoRestController {

    @Autowired
    private PrivadoRepository privadoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Privado> findAll() {
        return privadoRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{privadoId}")
    public Privado findOne(@PathVariable Long privadoId) {
        return privadoRepository.findOne(privadoId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public Privado add(@RequestBody Privado privado) {
        return privadoRepository.save(privado);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Privado update(@RequestBody Privado privado) {
        return privadoRepository.save(privado);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{privadoId}")
    public void delete(@PathVariable Long privadoId) {
        privadoRepository.delete(privadoId);
    }
	
}

