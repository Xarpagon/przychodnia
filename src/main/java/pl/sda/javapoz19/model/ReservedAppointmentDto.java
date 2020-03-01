package pl.sda.javapoz19.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class ReservedAppointmentDto {

    private  String doctorFullName;

    private  String patientFullName;

    private LocalDateTime appointmentDate;

    private  String description;

    public ReservedAppointmentDto(String doctorFullName, String patientFullName, LocalDateTime appointmentDate, String description) {
        this.doctorFullName = doctorFullName;
        this.patientFullName = patientFullName;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    public String getPatientFullName() {
        return patientFullName;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
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

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservedAppointmentDto that = (ReservedAppointmentDto) o;
        return Objects.equals(doctorFullName, that.doctorFullName) &&
                Objects.equals(patientFullName, that.patientFullName) &&
                Objects.equals(appointmentDate, that.appointmentDate) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorFullName, patientFullName, appointmentDate, description);
    }
}
