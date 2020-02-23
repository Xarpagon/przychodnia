package pl.sda.javapoz19.model;


import java.time.LocalDate;

public class MedicalAppointment {

    private Long appointmentId;
    private LocalDate appointmentDate;
    private Doctor doctor;
    private Patient patient;
    private String description;


    public MedicalAppointment(Long appointmentId, LocalDate appointmentDate, Doctor doctor, Patient patient, String description) {
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.patient = patient;
        this.description=description;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
