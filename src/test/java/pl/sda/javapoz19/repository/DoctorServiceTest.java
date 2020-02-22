package pl.sda.javapoz19.repository;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.service.DoctorService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.sda.javapoz19.model.Specialization.UROLOGIST;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DoctorServiceTest {

    @Autowired
    private DoctorService sut;

    @Test
    public void showAllDoctorsByLastNameShouldReturnDoctorListSize1ForLastNameZenkowski() {

        //when
        int expected = 1;

        //given
        List<Doctor> actual = sut.showAllDoctorsByLastName("Zenkowski");

        //then
        Assert.assertEquals(expected,actual.size());

    }

   /* @Test
    public void showDoctorsWithSpecializationShouldReturnDoctorListSize2ForUrologistSpecialization(){

        //when
        int expected = 2;

        //given
        List<Doctor> actual = sut.showDoctorsWithSpecialization("urologist");

        //then
        Assert.assertEquals(expected,actual.size());

    }

    @Test
    public void showAllDoctorsBySpecializationShouldReturnDoctorListSize2ForUrologistSpecialization(){

        //when
        int expected = 2;

        //given
        List<Doctor> actual = sut.showAllDoctorsBySpecialization(UROLOGIST);

        //then
        Assert.assertEquals(expected,actual.size());

    }*/




}