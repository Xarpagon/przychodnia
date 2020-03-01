package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.model.Specialization;


import java.util.List;
import java.util.Set;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

     Doctor findDoctorById(Long id);
     @Query("select d from Doctor d where d.user.pesel = :identityNumber")
     Doctor findDoctorByPesel(String identityNumber);
     @Query("select d from Doctor d where d.user.lastName = :lastName")

     List<Doctor> findDoctorsByLastName(String lastName);


     List<Doctor> findDoctorsBySpecialization(Specialization specialization);








}
