package pl.sda.javapoz19.controller;

import org.springframework.web.bind.annotation.RestController;
import pl.sda.javapoz19.service.PatientService;


@RestController
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;

    }




}
