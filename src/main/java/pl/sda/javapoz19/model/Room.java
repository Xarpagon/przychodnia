package pl.sda.javapoz19.model;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Room {

    private String floorNumber;
    private String doorNumber;

    public Room() {
    }

    public Room(String floorNumber, String doorNumber) {
        this.floorNumber = floorNumber;
        this.doorNumber = doorNumber;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(floorNumber, room.floorNumber) &&
                Objects.equals(doorNumber, room.doorNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorNumber, doorNumber);
    }
}
