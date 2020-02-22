package pl.sda.javapoz19.service;

import org.springframework.stereotype.Service;
import pl.sda.javapoz19.model.Address;
import pl.sda.javapoz19.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> showAllAddresses(){

        return addressRepository.findAll();

    }


    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }
}
