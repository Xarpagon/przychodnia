package pl.sda.javapoz19.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sda.javapoz19.model.Appointment;

import java.util.List;
import java.util.Optional;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllByDoctorId(Long id);

    List<Appointment> findAppointmentsByDoctorIdAndPatientNotNull(Long id);





}
