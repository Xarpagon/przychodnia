package pl.sda.javapoz19.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(generator = "doctorSeq")
    @SequenceGenerator(name = "doctorSeq", sequenceName = "doctor_Seq", allocationSize = 1)
    private Long id ;

    private String pesel;


    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Embedded
    private Address address;

    private String phoneNumber;
    private String emailAddress;


    public String getFullName(){
        return firstName + " " + lastName;
    }

    public Doctor() {
    }

    public Doctor(Long id, String pesel, String firstName, String lastName, Specialization specialization, Address address, String phoneNumber, String emailAddress) {
        this.id = id;
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) &&
                Objects.equals(pesel, doctor.pesel) &&
                Objects.equals(firstName, doctor.firstName) &&
                Objects.equals(lastName, doctor.lastName) &&
                specialization == doctor.specialization &&
                Objects.equals(address, doctor.address) &&
                Objects.equals(phoneNumber, doctor.phoneNumber) &&
                Objects.equals(emailAddress, doctor.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pesel, firstName, lastName, specialization, address, phoneNumber, emailAddress);
    }
}
