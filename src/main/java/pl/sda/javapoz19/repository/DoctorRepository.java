package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javapoz19.model.Doctor;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    List<Doctor> findByLastName(String lastName);

}
