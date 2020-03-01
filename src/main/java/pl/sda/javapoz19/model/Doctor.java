package pl.sda.javapoz19.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(generator = "doctorSeq")
    @SequenceGenerator(name = "doctorSeq", sequenceName = "doctor_seq", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = User.class)
    private User user;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    @Embedded
    private Room room;


    public Doctor() {
    }

    public Doctor(User user, Specialization specialization, Room room){
        this.user=user;
        this.specialization=specialization;
        this.room=room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long doctorId) {
        this.id = doctorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) &&
                Objects.equals(user, doctor.user) &&
                specialization == doctor.specialization &&
                Objects.equals(room, doctor.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, specialization, room);
    }
}
