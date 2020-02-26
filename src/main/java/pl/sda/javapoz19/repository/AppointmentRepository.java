package pl.sda.javapoz19.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.sda.javapoz19.model.Appointment;

import java.util.List;
;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDoctorId(Long id);

    List<Appointment> findAppointmentsByDoctorIdAndPatientIsNull(Long id);

    List<Appointment> findAppointmentsByDoctorIdAndPatientNotNull(Long id);





}
