package pl.sda.javapoz19.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.sda.javapoz19.model.MedicalAppointmentDto;
import pl.sda.javapoz19.service.DoctorService;

public class MedicalAppointmentController {

    private final DoctorService doctorService;

    public MedicalAppointmentController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping(value = "/MedicalAppointment/getDto", consumes = "application/json")
    public MedicalAppointmentDto getDto(@RequestBody MedicalAppointmentDto medicalAppointmentDto){
        return null;
    }
}


