package pl.sda.javapoz19.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class AppointmentDto {


    private Doctor doctor;

    private LocalDate date;

    private LocalTime from;

    private LocalTime upTill;

    private int duration;

    public AppointmentDto(Doctor doctor, LocalDate date, LocalTime from, LocalTime upTill, int duration) {
        this.date = date;
        this.from = from;
        this.upTill = upTill;
        this.duration = duration;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(date, that.date) &&
                Objects.equals(from, that.from) &&
                Objects.equals(upTill, that.upTill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, date, from, upTill, duration);
    }
}
