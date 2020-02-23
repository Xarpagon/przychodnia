package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.exceptions.DuplicatedUserNameException;
import pl.sda.javapoz19.model.Patient;
import pl.sda.javapoz19.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){this.patientRepository = patientRepository;}

    public List<Patient> showAllPatientsByPeselOrLastName(String pesel, String lastName)

    {return patientRepository.findAllByPeselOrLastName(pesel,lastName);}

    public Long addPatient(Patient patient){
        patientRepository.findAll().stream()
                .filter(presentPatient -> presentPatient.getPesel().equals(patient.getPesel()))
                .findAny()
                .ifPresent(patient1 -> throwDuplicatedUserNameExeption(patient1.getPesel()));

        patientRepository.save(patient);
        return patient.getId();
    }

    private void throwDuplicatedUserNameExeption(String username) {
        throw new DuplicatedUserNameException("User " + username + "already exists.");
    }


}
