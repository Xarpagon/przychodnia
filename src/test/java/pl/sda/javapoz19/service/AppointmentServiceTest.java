package pl.sda.javapoz19.service;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.javapoz19.model.Address;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.model.AppointmentDto;
import pl.sda.javapoz19.model.Specialization;

import java.time.LocalDate;

import java.time.LocalTime;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AppointmentServiceTest {

    private AppointmentService appointmentService = new AppointmentService(null);

    @Test
    public void convertToEntitiesListShouldReturnSize4ForWorkingHours14To16(){

        //given
            Address address = new Address("Brzozowa", "1", "88700", "Piła", "Poland");
            Doctor doctor = new Doctor(1L, "82121619936", "John", "Warki",
                    Specialization.UROLOGIST, address, "+48500600540", "awar@wp.pl");
            AppointmentDto AppointmentDto = new AppointmentDto(doctor, LocalDate.of(2020,02,24),
                    LocalTime.of(14,0),LocalTime.of(16,0),30);

            int expectedListSize = 4;
            LocalTime expected = LocalTime.of(15,0);

        //when
        LocalTime actual = appointmentService.convertToEntitiesList(AppointmentDto).get(2).getAppointmentTime();

        int actualSize = appointmentService.convertToEntitiesList(AppointmentDto).size();

        //then
        Assert.assertEquals(expected,actual);
    }


}