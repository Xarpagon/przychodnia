package pl.sda.javapoz19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pl.sda.javapoz19.model.Patient;
import pl.sda.javapoz19.service.PatientService;

import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){this.patientService = patientService;}

    @GetMapping(value ="/patients/{pesel},{lastName}", produces ="application/json")
    public List<Patient> patientsByPeselOrLastName(@PathVariable String pesel, @PathVariable String lastName){
        return patientService.showAllPatientsByPeselOrLastName(pesel,lastName);
    }
}
