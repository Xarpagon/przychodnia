package pl.sda.javapoz19.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import pl.sda.javapoz19.model.User;
import pl.sda.javapoz19.service.UserService;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.noContent;


@RestController
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @GetMapping(value = "/user/username", produces = "application/json")
    public ResponseEntity<User> showUserById(@RequestParam(required = false) String username){
        Optional<User> user = userService.retrieveUserById(username);
        if(!user.isPresent()){
            System.out.println("User with " + username + "does not exist");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user.get());
    }
    @GetMapping(value ="/user", produces ="application/json")
    public User showUserByPeselOrLastName(@RequestParam(required = false) String pesel,@RequestParam(required = false) String lastName){
        return userService.showUserByPeselOrLastName(pesel,lastName);
    }

    @GetMapping(value = "/users", produces = "application/json")
    public List<User> showAllUsers(){
        return userService.retrieveAllUsers();
    }


    @PostMapping(value = "/users/add", consumes = "application/json")
    public ResponseEntity<String> submitUser(@RequestBody User user){
        return new ResponseEntity<String>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/doctor/update", consumes = "application/json")
    public ResponseEntity<String> updateUserDoctor(@RequestBody User user){
         return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping(value ="/user/delete/{username}")
    public ResponseEntity<Void>deleteUserByUsername(@PathVariable String username){
        userService.removeUserByUsername(username);
        return noContent().build();

    }



}
