package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.javapoz19.model.Patient;

import java.util.List;


public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient> findAllByPeselOrLastName(String pesel,String lastName);


}
