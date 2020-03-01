package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.exception.AppointmentNotFoundException;
import pl.sda.javapoz19.model.*;
import pl.sda.javapoz19.repository.AppointmentRepository;
import pl.sda.javapoz19.repository.DoctorRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

   /* private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;


    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
    }

    public List<Appointment> showAvailableAppointmentsByDoctorId(Long id){
        return appointmentRepository.findAppointmentsByDoctorIdAndPatientIsNull(id);
    }

    public Optional<Appointment> addArrangedAppointment(Patient patient, Appointment appointment){

        Optional<Appointment>  appointmentToArrange =  showAvailableAppointmentsByDoctorId(appointment.getDoctor().getId()).stream()
                .filter(appointment1 -> appointment1.getAppointmentDate().equals(appointment.getAppointmentDate()))
                .findAny();

            appointmentToArrange.ifPresentOrElse(appointment1 -> appointment1.setPatient(patient),
                  () -> {throw new AppointmentNotFoundException("Appointment not available");});

            appointmentRepository.save(appointmentToArrange.get());
        return appointmentToArrange;

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
        LocalDateTime appointmentDate = appointment.getAppointmentDate();
        String description = appointment.getDescription();

        return new ReservedAppointmentDto(doctorFullName, patientFullName, appointmentDate, description);
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



           while(appointmentTime.isBefore(endTime)){

               Appointment appointment = new Appointment();

               appointment.setDoctor(getDoctorById(aDto));
               appointment.setAppointmentDate(aDto.getDate());

               appointmentList.add(appointment);

               appointmentTime = appointmentTime.plusMinutes(duration);


           }

        return appointmentList;
    }

    private Doctor getDoctorById(AppointmentDto aDto) {
        Long dtoDoctorId = aDto.getDoctorId();
        return doctorRepository.findDoctorById(dtoDoctorId);

    }*/






}
