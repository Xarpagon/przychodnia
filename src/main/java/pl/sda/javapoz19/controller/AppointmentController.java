package pl.sda.javapoz19.controller;

import org.springframework.web.bind.annotation.*;
import pl.sda.javapoz19.model.Appointment;
import pl.sda.javapoz19.model.AppointmentDto;

import pl.sda.javapoz19.model.Patient;
import pl.sda.javapoz19.model.ReservedAppointmentDto;
import pl.sda.javapoz19.service.AppointmentService;
import pl.sda.javapoz19.service.DoctorService;


import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;


    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "/appointments/doctor/{id}", produces = "application/json")
    public List<Appointment> showAppointmentsByDoctor(@PathVariable Long id){
        return appointmentService.showAllAppointmentsByDoctorId(id);
    }

    @GetMapping(value = "/appointments/reserved/doctor/{id}", produces = "application/json")
    public List<ReservedAppointmentDto> showReservedAppointmentsByDoctor(@PathVariable Long id){

        return appointmentService.fetchAllReservedAppointmentsByDoctorId(id);
    }

    @GetMapping(value = "/appointments/availableAppointments/doctor/{id}", produces = "application/json")
    public List<Appointment> showAvailableAppointmentsByDoctor(@PathVariable Long id){
        return appointmentService.showAvailableAppointmentsByDoctorId(id);
    }

    @PostMapping(value = "/appointment/patient/set", consumes = "application/json")
    public Optional<Appointment> addAppointmentArrangedByPatient(@PathVariable Patient patient, @PathVariable Appointment appointment){
        return appointmentService.addArrangedAppointment(patient,appointment);
    }



    @PostMapping(value = "/appointments/doctor/schedule", consumes = "application/json")
    public List<Appointment> addAppointmentsScheduleByDoctor(@RequestBody AppointmentDto appointmentDto){
        return appointmentService.addAppointments(appointmentDto);

    }








}


