package pl.sda.javapoz19.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(generator = "appointmentSeq")
    @SequenceGenerator(name = "appointmentSeq", sequenceName = "appointment_Seq", allocationSize = 1)
    private Long id;

    @ManyToOne(targetEntity = Doctor.class)
    private Doctor doctor;

    @ManyToOne(targetEntity = User.class)
    private User patient;

    private LocalDateTime appointmentDate;

    private String description;


    public Appointment() {
    }

    public Appointment(Doctor doctor, LocalDateTime appointmentDate) {
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public Appointment(Long id, Doctor doctor, User user, LocalDateTime appointmentDate, String description) {
        this.id = id;
        this.doctor = doctor;
        this.patient = user;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User user) {
        this.patient = user;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, patient, appointmentDate, description);
    }
}
