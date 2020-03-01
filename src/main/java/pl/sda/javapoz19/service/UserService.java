package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.exception.DuplicatedUserNameException;
import pl.sda.javapoz19.model.User;
import pl.sda.javapoz19.repository.UserRepository;



@Service
public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;



    public User showUserByPeselOrLastName(String pesel, String lastName)
    {return userRepository.findByPeselAndLastName(pesel,lastName);}

    public User showUserByUsername(String username){
        return userRepository.findById(username).orElse(null);
    }

    public String addUser(User user){
        userRepository.findAll().stream()
                .filter(presentUser -> presentUser.getPesel().equals(user.getPesel()))
                .findAny()
                .ifPresent(user1 -> throwDuplicatedUserNameException(user1.getPesel()));

        userRepository.save(user);
        return user.getUsername();
    }

    private void throwDuplicatedUserNameException(String username) {
        throw new DuplicatedUserNameException("User " + username + "already exists.");
    }

    public void removeUserByUsername(String username) {
         userRepository.deleteById(username);
    }

    /*
    public List<Patient>deletePatientById(Long Id)
    {return patientRepository.deletePatientById(Id);}
*/
}
