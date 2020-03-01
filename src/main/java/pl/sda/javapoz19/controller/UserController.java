package pl.sda.javapoz19.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import pl.sda.javapoz19.model.User;
import pl.sda.javapoz19.service.UserService;




@RestController
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;


    @GetMapping(value ="/patient", produces ="application/json")
    public User userByPeselOrLastName(@RequestParam(required = false) String pesel,@RequestParam(required = false) String lastName){
        return userService.showUserByPeselOrLastName(pesel,lastName);
    }

    @GetMapping(value = "/patient/{username}", produces = "application/json")
    public User patientById(@PathVariable String username){
        return userService.showUserByUsername(username);
    }
/*
    @PostMapping(value = "/patients/add", consumes = "application/json")
    public ResponseEntity<Long> submitPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }


    @PostMapping(value ="/patients/delete/{id}", consumes = "application/json")
    public ResponseEntity<Long>deletePatientsById(@PathVariable Long id){
        patientService.deletePatientById(id);
        return new ResponseEntity<Long>(HttpStatus.OK);

    }*/

}
