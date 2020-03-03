package pl.sda.javapoz19.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.javapoz19.model.Address;
import pl.sda.javapoz19.model.Doctor;
import pl.sda.javapoz19.model.Role;
import pl.sda.javapoz19.model.User;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Autowired
    private UserService sut;

    @Test
    void retrieveUserByIdShouldReturnLastNameMarkowskiForIdUsernameMaro() {

        //given
        String username = "maro";
        String expectedResult = "Markowski";
        //when
        Optional<User> actual = sut.retrieveUserById(username);

        //then
        Assert.assertEquals(expectedResult,actual.get().getLastName());

    }

    @Test
    void retrieveUserByIdShouldReturnNullForDoctorSpecializationWithIdUsernameMaro(){
        //given
        String username = "maro";
        Doctor expectedResult = null;

        //when
        Optional<User> actual = sut.retrieveUserById(username);

        //then
        Assert.assertEquals(expectedResult,actual.get().getDoctor());
    }

    @Test
    void retrieveAllUsersShouldReturnSize7ForListOfUsers(){

        //given
        int expectedSize = 7;

        //when
        List<User> allUsers = sut.retrieveAllUsers();

        //then
        Assert.assertEquals(expectedSize,allUsers.size());

    }

    @Test
    void addUserReturnsTableSize8(){

        //given
        Role role = new Role(1l,"USER");
        Address address = new Address("Sucha", "1", "99009", "city", "country");
        User user = new User("adek", "123", role, "pesel", "firstname",
                "lastname", address,"phone number", "email", null, null);

        int expectedSize = 8;

        //when
        String actualUsername = sut.addUser(user);
        int actualSize = sut.retrieveAllUsers().size();

        //then
        Assert.assertEquals(expectedSize,actualSize);

    }




}