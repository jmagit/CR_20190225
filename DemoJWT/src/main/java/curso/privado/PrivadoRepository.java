package curso.privado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivadoRepository extends JpaRepository<Privado, Long> {
    //User findByUsername(String username);
}
