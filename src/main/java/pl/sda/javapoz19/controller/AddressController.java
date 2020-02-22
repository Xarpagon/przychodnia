package pl.sda.javapoz19.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.javapoz19.model.Address;
import pl.sda.javapoz19.service.AddressService;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/addresses", produces = "application/json")
    public List<Address> showAllAddresses(){
        return addressService.showAllAddresses();
    }

    @PostMapping(value = "/address/add", consumes = "application/json")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.CREATED);
    }


}
