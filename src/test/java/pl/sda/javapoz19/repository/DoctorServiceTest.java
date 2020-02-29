package pl.sda.javapoz19.repository;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.javapoz19.model.Address;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.model.Room;
import pl.sda.javapoz19.model.Specialization;
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

        //given
        int expected = 1;

        //when
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

   @Test
    public void addDoctorShouldReturnDoctorId1ForAddedDoctor(){

       //given
       Address address = new Address("Jan", "12", "40400", "City", "Pol");
       Room room = new Room("2", "12");
       Doctor doctorToAdd = new Doctor("51121213459","Mirek", "Mirkowski", UROLOGIST, address, "1",
               "99000", room);

       Long expected = 5l;

       //when
       Long actual = sut.addDoctor(doctorToAdd);

       //then
       Assert.assertEquals(expected, actual);


   }

  /* @Test
    public void updateDoctorDetailsShouldReturnUpdatedEmailOfDoctorZenkowski(){
       //given
       Address address = new Address("Brzozowa", "1", "88500", "Sieradz", "Poland");
       Room room = new Room("2", "14");
       Doctor updatedDoctor = new Doctor("50121213459","Zenek", "Zenkowski", UROLOGIST, address, "+48999999999",
               "zen.zenkowski@wp.pl", room);

       String expected = "zen.zenkowski@wp.pl";


       //when
       String actual = sut.updateDoctorDetails(updatedDoctor).getEmailAddress();

       //then
       Assert.assertEquals(expected, actual);
   }*/




}