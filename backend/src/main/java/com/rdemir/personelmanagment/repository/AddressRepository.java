package com.rdemir.personelmanagment.repository;

import com.rdemir.personelmanagment.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
