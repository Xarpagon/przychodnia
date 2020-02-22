package pl.sda.javapoz19.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue(generator = "addressSeq")
    @SequenceGenerator(name = "addressSeq", sequenceName = "address_Seq", allocationSize = 1)
    private Long id;
    private String street;
    private String houseNumber;
    private String postcode;
    private String city;

    public Address() {
    }

    public Address(Long id, String street,String houseNumber, String postcode, String city){
        this.street = street;
        this.houseNumber=houseNumber;
        this.postcode = postcode;
        this.city = city;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(street, address.street) &&
                Objects.equals(postcode, address.postcode) &&
                Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, postcode, city);
    }
}
