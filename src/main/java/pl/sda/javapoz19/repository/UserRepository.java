package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    User findByPeselAndLastName(String pesel, String lastName);

    @Query("select u from User u where u.pesel = :identityNumber and u.doctor is not null")
    User findDoctorByPesel(String identityNumber);

    @Query("select u from User u where u.lastName = :lastName and u.doctor is not null")
    List<User> findDoctorsByLastName(String lastName);

    @Query("select u from User u where u.username = :username and u.doctor is not null")
    User findDoctorById(String username);






}