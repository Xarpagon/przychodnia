package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.exception.DuplicatedUserNameException;
import pl.sda.javapoz19.model.User;
import pl.sda.javapoz19.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;



    public User showUserByPeselOrLastName(String pesel, String lastName)
    {return userRepository.findByPeselAndLastName(pesel,lastName);}

    /*public Patient showPatientById(Long id){
        return patientRepository.findPatientById(id);
    }

    public Long addPatient(Patient patient){
        patientRepository.findAll().stream()
                .filter(presentPatient -> presentPatient.getPesel().equals(patient.getPesel()))
                .findAny()
                .ifPresent(patient1 -> throwDuplicatedUserNameException(patient1.getPesel()));

        patientRepository.save(patient);
        return patient.getId();
    }

    private void throwDuplicatedUserNameException(String username) {
        throw new DuplicatedUserNameException("User " + username + "already exists.");
    }
    public List<Patient>deletePatientById(Long Id)
    {return patientRepository.deletePatientById(Id);}
*/
}
