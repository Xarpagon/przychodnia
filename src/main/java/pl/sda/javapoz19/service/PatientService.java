package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.model.Appointment;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.model.Specialization;
import pl.sda.javapoz19.repository.AppointmentRepository;
import pl.sda.javapoz19.repository.DoctorRepository;
import pl.sda.javapoz19.repository.PatientRepository;

import java.util.List;
import java.util.Set;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
}
