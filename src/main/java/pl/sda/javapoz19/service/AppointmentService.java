package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.model.*;
import pl.sda.javapoz19.repository.AppointmentRepository;
import pl.sda.javapoz19.repository.DoctorRepository;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<Appointment> showAvailableAppointmentsByDoctorId(Long id){
        return appointmentRepository.findAppointmentsByDoctorIdAndPatientIsNull(id);
    }

    public List<Appointment> showAllAppointmentsByDoctorId(Long id){
        return appointmentRepository.findAllByDoctorId(id);

    }

    public List<ReservedAppointmentDto> fetchAllReservedAppointmentsByDoctorId(Long id){

        return convertToReservedAppointmentDto(appointmentRepository.findAppointmentsByDoctorIdAndPatientNotNull(id));
    }

    public List<ReservedAppointmentDto> convertToReservedAppointmentDto(List<Appointment> appointments){

        return appointments.stream()
                .map(appointment1 -> toDto(appointment1)).collect(Collectors.toList());


    }

    public ReservedAppointmentDto toDto(Appointment appointment){

        String doctorFullName = appointment.getDoctor().getFirstName() + " " + appointment.getDoctor().getLastName();
        String patientFullName = appointment.getPatient().getFirstName() + " " + appointment.getPatient().getLastName();
        LocalDate appointmentDate = appointment.getAppointmentDate();
        LocalTime appointmentTime = appointment.getAppointmentTime();
        String description = appointment.getDescription();

        return new ReservedAppointmentDto(doctorFullName, patientFullName, appointmentDate,appointmentTime, description);
    }


    public List<Appointment> addAppointments(AppointmentDto aDto){

        List<Appointment> medicalAppointmentList = convertToEntitiesList(aDto);

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


               Long dtoDoctorId = aDto.getDoctorId();
               doctorRepository.findDoctorById(dtoDoctorId);

               appointment.setDoctor(getDoctorById(aDto));
               appointment.setAppointmentDate(aDto.getDate());
               appointment.setAppointmentTime(appointmentTime);



               appointmentList.add(appointment);

               appointmentTime = appointmentTime.plusMinutes(duration);

               id++;

           }

        return appointmentList;
    }

    private Doctor getDoctorById(AppointmentDto aDto) {
        Long dtoDoctorId = aDto.getDoctorId();
        return doctorRepository.findDoctorById(dtoDoctorId);

    }






}
