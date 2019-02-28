package curso.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
