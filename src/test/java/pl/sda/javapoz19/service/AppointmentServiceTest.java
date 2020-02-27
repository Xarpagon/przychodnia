package pl.sda.javapoz19.service;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.javapoz19.model.*;
import pl.sda.javapoz19.repository.AppointmentRepository;
import pl.sda.javapoz19.repository.DoctorRepository;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AppointmentServiceTest {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;


    @Test
    public void convertToEntitiesListShouldReturnSize4ForWorkingHours14To16() {

        //given
        Address address = new Address("Brzozowa", "1", "88700", "Piła", "Poland");
        Room room = new Room("1", "2");
        Doctor doctor = new Doctor(1L, "82121619936", "John", "Warki",
                Specialization.UROLOGIST, address, "+48500600540", "awar@wp.pl", room);
        AppointmentDto appointmentDto = new AppointmentDto(1l, LocalDate.of(2020, 02, 24),
                LocalTime.of(14, 0), LocalTime.of(16, 0), 30);

        int expectedListSize = 4;


        //when

        int actualListSize = appointmentService.convertToEntitiesList(appointmentDto).size();

        //then
        Assert.assertEquals(expectedListSize, actualListSize);
    }

    @Test
    public void convertToEntitiesListShouldReturnAppointmentTime1430ForAppointmentIndex5() {


    //given
    Address address = new Address("Brzozowa", "1", "88700", "Piła", "Poland");
    Room room = new Room("2", "9");
    Doctor doctor = new Doctor(1L, "82121619936", "John", "Warki",
            Specialization.UROLOGIST, address, "+48500600540", "awar@wp.pl", room);
    AppointmentDto appointmentDto = new AppointmentDto(1l, LocalDate.of(2020, 02, 24),
            LocalTime.of(12, 0), LocalTime.of(15, 0), 30);

    LocalTime expectedAppointmentTime = LocalTime.of(14, 30);

    //when

    LocalTime actualAppointmentTime = appointmentService.convertToEntitiesList(appointmentDto).get(5).getAppointmentTime();

    //then
        Assert.assertEquals(expectedAppointmentTime,actualAppointmentTime);
    }

    @Test
    public void addArrangedAppointmentShouldReturnPatientId1ForArrangedAppointmentWithPatientNull(){

        //given
        /*Address address = new Address("Brzozowa", "1", "88700", "Piła", "Poland");
        Room room = new Room("2", "9");
        Patient patient1 = new Patient(1l,"82121618845","Arek","Arkański",
                address,"arek.arkański@gmail.com", "+48600650640");
        Doctor doctor = new Doctor(1L, "82121619936", "John", "Warki",
                Specialization.UROLOGIST, address, "+48500600540", "awar@wp.pl", room);

        Appointment appointment = new Appointment(1l,doctor,null,LocalDate.of(2020,03,02),
                LocalTime.of(14,30), null);*/


        Patient patient = patientService.showPatientById(1l);
        Appointment appointment = appointmentService.showAvailableAppointmentsByDoctorId(1l).get(0);
        Long expectedPatientId = 1l;
        //when

        Optional<Appointment> actualAppointment = appointmentService.addArrangedAppointment(patient, appointment);

        //then
        Assert.assertEquals(expectedPatientId,actualAppointment.get().getPatient().getId());

    }
}