package pl.sda.javapoz19.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import pl.sda.javapoz19.model.User;
import pl.sda.javapoz19.service.UserService;

import static org.springframework.http.ResponseEntity.noContent;


@RestController
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;


    @GetMapping(value ="/user", produces ="application/json")
    public User userByPeselOrLastName(@RequestParam(required = false) String pesel,@RequestParam(required = false) String lastName){
        return userService.showUserByPeselOrLastName(pesel,lastName);
    }

    @GetMapping(value = "/user/{username}", produces = "application/json")
    public User showUserByUsername(@PathVariable String username){
        return userService.showUserByUsername(username);
    }

    @PostMapping(value = "/users/add", consumes = "application/json")
    public ResponseEntity<String> submitPatient(@RequestBody User patient){
        return new ResponseEntity<String>(userService.addUser(patient), HttpStatus.CREATED);
    }

    @DeleteMapping(value ="/user/delete/{username}")
    public ResponseEntity<Void>deleteUserByUsername(@PathVariable String username){
        userService.removeUserByUsername(username);
        return noContent().build();

    }



}
