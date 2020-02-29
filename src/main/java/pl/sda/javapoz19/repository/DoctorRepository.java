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

     Doctor findDoctorByPesel(String identityNumber);

     List<Doctor> findDoctorsByLastName(String lastName);


     List<Doctor> findDoctorsBySpecialization(Specialization specialization);

     void deleteDoctorByPesel(String pesel);

     void deleteDoctorByLastName(String lastName);






}
