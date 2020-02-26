package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.model.Appointment;
import pl.sda.javapoz19.repository.AppointmentRepository;

import java.util.List;

@Service
public class PatientService {

    private final AppointmentRepository appointmentRepository;


    public PatientService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> showAvailableAppointmentsByDoctorId(Long id){
        return appointmentRepository.findAppointmentsByDoctorIdAndPatientIsNull(id);
    }
}
