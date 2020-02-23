package pl.sda.javapoz19.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.model.Specialization;
import pl.sda.javapoz19.service.DoctorService;

import java.util.List;


@RestController
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(value = "/doctors/{lastName}", produces = "application/json")
    public List<Doctor> doctorsByLastName(@PathVariable String lastName){
        return doctorService.showAllDoctorsByLastName(lastName);
    }

    @PostMapping(value = "/doctor/add", consumes = "application/json")
    public ResponseEntity<Long> submitDoctor(@RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorService.addDoctor(doctor), HttpStatus.CREATED);
    }

   /* @GetMapping(value = "/doctors/{specialization}", produces = "application/json")
    public List<Doctor> doctorsBySpecialization(@PathVariable String specialization){

        return doctorService.showDoctorsWithSpecialization(specialization);
    }*/
}
