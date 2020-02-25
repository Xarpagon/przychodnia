package pl.sda.javapoz19.controller;

import org.springframework.web.bind.annotation.*;
import pl.sda.javapoz19.model.Appointment;
import pl.sda.javapoz19.model.AppointmentDto;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.service.AppointmentService;
import pl.sda.javapoz19.service.DoctorService;

import java.util.List;

@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/Appointments/doctor/{id}", produces = "application/json")
    public List<Appointment> showAppointmentsByDoctor(@PathVariable Long id){
        return appointmentService.showAllAppointmentsByDoctorId(id);
    }

    @GetMapping(value = "/Appointment/doctor/reserved/{id}", produces = "application/json")
    public List<Appointment> showReservedAppointmentsByDoctor(@PathVariable Long id){
        return appointmentService.fetchAllReservedAppointmentsByDoctorId(id);
    }



    @PostMapping(value = "/Appointment/doctor/schedule", consumes = "application/json")
    public List<Appointment> addAppointmentsScheduleByDoctor(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.addAppointments(appointmentDto);

    }








}


