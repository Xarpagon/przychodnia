package pl.sda.javapoz19.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Patient {

    @Id
    @GeneratedValue(generator = "patientSeq")
    @SequenceGenerator(name="patientSeq", sequenceName = "patient_Seq", allocationSize = 1)
    private Long id;

    private String pesel;
    private String firstName;
    private String lastName;

    @Embedded
    private Address address;

    private String email;
    private String phoneNumber;


    public Patient() {
    }

    public Patient(Long id, String pesel, String firstName, String lastName, Address address, String email, String phoneNumber) {
        this.id = id;
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) &&
                Objects.equals(pesel, patient.pesel) &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(email, patient.email) &&
                Objects.equals(phoneNumber, patient.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pesel, firstName, lastName, address, email, phoneNumber);
    }

}