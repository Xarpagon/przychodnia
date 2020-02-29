package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javapoz19.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByUsername(String username);

}