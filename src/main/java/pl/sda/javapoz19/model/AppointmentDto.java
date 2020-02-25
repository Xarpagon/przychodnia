package pl.sda.javapoz19.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class AppointmentDto {


    private Long  doctor_id;

    private LocalDate date;

    private LocalTime from;

    private LocalTime upTill;

    private int duration;

    public AppointmentDto(Long doctor_id, LocalDate date, LocalTime from, LocalTime upTill, int duration) {
        this.doctor_id=doctor_id;
        this.date = date;
        this.from = from;
        this.upTill = upTill;
        this.duration = duration;
    }

    public Long getDoctorId() {
        return doctor_id;
    }

    public void setDoctorId(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getUpTill() {
        return upTill;
    }

    public void setUpTill(LocalTime upTill) {
        this.upTill = upTill;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentDto that = (AppointmentDto) o;
        return duration == that.duration &&
                Objects.equals(doctor_id, that.doctor_id) &&
                Objects.equals(date, that.date) &&
                Objects.equals(from, that.from) &&
                Objects.equals(upTill, that.upTill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor_id, date, from, upTill, duration);
    }
}
