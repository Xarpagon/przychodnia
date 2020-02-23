package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.javapoz19.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByUserName(String firstName);

    @Query("select u from User u where u.username = :username")

    List<User> searchByUserName(@Param("userName") String userName);
}