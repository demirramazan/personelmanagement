package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.model.Address;
import com.rdemir.personelmanagment.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address getdById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
