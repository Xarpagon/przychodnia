package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javapoz19.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}