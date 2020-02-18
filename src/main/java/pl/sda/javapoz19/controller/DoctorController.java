package pl.sda.javapoz19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javapoz19.model.Doctor;
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
}
