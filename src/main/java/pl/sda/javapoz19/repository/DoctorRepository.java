package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.model.Specialization;


import java.util.List;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

     Doctor findDoctorById(Long id);

     Doctor findDoctorByPesel(String identityNumber);

     List<Doctor> findDoctorsByLastName(String lastName);

     @Query("select d From Doctor d where d.specialization = :specialization")
     List<Doctor> findDoctorsBySpecialization(@Param("specialization") Specialization specialization);

     void deleteDoctorByLastName(String lastName);





}
