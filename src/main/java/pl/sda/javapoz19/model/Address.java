package pl.sda.javapoz19.model;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Address {

    private String street;
    private String houseNumber;
    private String postcode;
    private String city;
    private String country;

    public Address() {
    }

    public Address(String street,String houseNumber, String postcode, String city, String country){
        this.street = street;
        this.houseNumber=houseNumber;
        this.postcode = postcode;
        this.city = city;
        this.country=country;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(houseNumber, address.houseNumber) &&
                Objects.equals(postcode, address.postcode) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, houseNumber, postcode, city, country);
    }
}