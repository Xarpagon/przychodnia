package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.exception.DuplicatedUserNameException;
import pl.sda.javapoz19.exception.UserNotFoundException;
import pl.sda.javapoz19.model.User;
import pl.sda.javapoz19.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    public Optional<User> retrieveUserById(String username){

        return userRepository.findById(username);
    }

    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    public User showUserByPeselOrLastName(String pesel, String lastName)
    {return userRepository.findByPeselAndLastName(pesel,lastName);}

    public String addUser(User user){
        userRepository.findAll().stream()
                .filter(presentUser -> presentUser.getUsername().equals(user.getUsername()))
                .findAny()
                .ifPresent(user1 -> throwDuplicatedUserNameException(user1.getUsername()));

        userRepository.save(user);
        return user.getUsername();
    }

    private void throwDuplicatedUserNameException(String username) {
        throw new DuplicatedUserNameException("User " + username + "already exists.");
    }

    public String updateUser(User user){

         User userToUpdate = Optional.ofNullable(userRepository.findDoctorById(user.getUsername()))
                 .orElseThrow(()-> new UserNotFoundException("Doctor does not exist"));
        userRepository.delete(userToUpdate);
        userRepository.save(user);

        return userToUpdate.getUsername();
    }

    public void removeUserByUsername(String username) {
         userRepository.deleteById(username);
    }

    /*
    public List<Patient>deletePatientById(Long Id)
    {return patientRepository.deletePatientById(Id);}
*/
}
