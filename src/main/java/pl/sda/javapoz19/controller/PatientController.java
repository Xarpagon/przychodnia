package pl.sda.javapoz19.controller;

import org.apache.coyote.Response;
import org.hibernate.sql.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.sda.javapoz19.model.Patient;
import pl.sda.javapoz19.service.PatientService;


import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){this.patientService = patientService;}

    @GetMapping(value ="/patients/{pesel},{lastName}", produces ="application/json")
    public List<Patient> patientsByPeselOrLastName(@PathVariable String pesel, @PathVariable String lastName){
        return patientService.showAllPatientsByPeselOrLastName(pesel,lastName);
    }

    @PostMapping(value = "/patients/add", consumes = "application/json")
    public ResponseEntity<Long> submitPatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }


    @PostMapping(value ="/patients/delete/{id}", consumes = "application/json")
    public ResponseEntity<Long>deletePatientsById(@PathVariable Long id){
        patientService.deletePatientById(id);
       return new ResponseEntity<Long>(HttpStatus.OK);

    }


}
