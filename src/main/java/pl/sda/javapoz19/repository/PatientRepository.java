package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javapoz19.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {


}
