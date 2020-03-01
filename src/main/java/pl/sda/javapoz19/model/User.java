package pl.sda.javapoz19.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Entity
public class User implements UserDetails {

    @Id
    private String username;
    private String password;


    @ManyToOne(targetEntity = Role.class)
    private Role role;

    private String pesel;

    private String firstName;

    private String lastName;

    @Embedded
    private Address address;

    private String phoneNumber;

    private String emailAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Appointment> appointmentSet;

    @OneToOne(cascade = CascadeType.ALL)
    private Doctor doctor;


    public User() {
    }

    public User(String username, String password, Role role, String pesel, String firstName, String lastName,
                Address address, String phoneNumber, String emailAddress, Set<Appointment> appointmentSet, Set<Doctor> doctorSet){
        this.username = username;
        this.password=password;
        this.role=role;
        this.pesel=pesel;
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.phoneNumber=phoneNumber;
        this.emailAddress=emailAddress;
        this.appointmentSet=appointmentSet;
        this.doctor=doctor;
    }



   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return emailAddress;
    }

    public void setEmail(String email) {
        this.emailAddress = emailAddress;
    }

    public Set<Appointment> getAppointmentSet() {
        return appointmentSet;
    }

    public void setAppointmentSet(Set<Appointment> appointmentSet) {
        this.appointmentSet = appointmentSet;
    }

    public Doctor getDoctorSet() {
        return doctor;
    }

    public void setDoctorSet(Doctor doctorSet) {
        this.doctor = doctorSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role) &&
                Objects.equals(pesel, user.pesel) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(address, user.address) &&
                Objects.equals(phoneNumber, user.phoneNumber) &&
                Objects.equals(emailAddress, user.emailAddress) &&
                Objects.equals(appointmentSet, user.appointmentSet) &&
                Objects.equals(doctor, user.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, role, pesel, firstName, lastName, address, phoneNumber, emailAddress, appointmentSet, doctor);
    }
}