package pl.sda.javapoz19.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.sda.javapoz19.model.Doctor;


import java.util.List;


public interface DoctorRepository extends JpaRepository<Doctor, Long> {

     Doctor findDoctorById(Long id);

     Doctor findDoctorByPesel(String identityNumber);

     List<Doctor> findDoctorsByLastName(String lastName);

     void deleteDoctorByLastName(String lastName);





}
