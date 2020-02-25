package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.model.*;
import pl.sda.javapoz19.repository.AppointmentRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.*;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> showAllAppointmentsByDoctorId(Long id){
        return appointmentRepository.findAllByDoctorId(id);

    }

    public List<Appointment> addMedicalAppointments(AppointmentDto madto){

        List<Appointment> medicalAppointmentList = convertToEntitiesList(madto);

        return appointmentRepository.saveAll(medicalAppointmentList);

    }

    public List<Appointment> convertToEntitiesList(AppointmentDto aDto){

        List<Appointment> appointmentList = new ArrayList<>();

        LocalTime startTime = aDto.getFrom();
        LocalTime endTime = aDto.getUpTill();

        int duration = aDto.getDuration();

        LocalTime appointmentTime = startTime;

        Long id = 1l;

           while(appointmentTime.isBefore(endTime)){

               Appointment appointment = new Appointment();

               appointment.setDoctor(aDto.getDoctor());
               appointment.setAppointmentDate(aDto.getDate());
               appointment.setAppointmentTime(appointmentTime);



               appointmentList.add(appointment);

               appointmentTime = appointmentTime.plusMinutes(duration);

               id++;

           }

        return appointmentList;
    }

    public static void main(String[] args) {
        AppointmentService medicalAppointmentService;
        Address address = new Address("Brzozowa", "1", "88700", "Piła", "Poland");
        Doctor doctor = new Doctor(1L, "82121619936", "John", "Warki",
                Specialization.UROLOGIST, address, "+48500600540", "awar@wp.pl");
        AppointmentDto medicalAppointmentDto = new AppointmentDto(doctor, LocalDate.of(2020,02,24),
                LocalTime.of(14,0),LocalTime.of(16,0),30);


    }


}
