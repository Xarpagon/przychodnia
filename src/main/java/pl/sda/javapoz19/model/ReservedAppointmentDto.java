package pl.sda.javapoz19.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservedAppointmentDto {

    private  String doctorFullName;

    private  String patientFullName;

    private  LocalDate appointmentDate;

    private  LocalTime appointmentTime;

    private  String description;

    public ReservedAppointmentDto(String doctorFullName, String patientFullName, LocalDate appointmentDate, LocalTime appointmentTime, String description) {
        this.doctorFullName = doctorFullName;
        this.patientFullName = patientFullName;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.description = description;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
