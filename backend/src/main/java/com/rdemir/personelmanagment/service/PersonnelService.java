package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.exception.NotFoundExceptionHandler;
import com.rdemir.personelmanagment.model.Address;
import com.rdemir.personelmanagment.model.Department;
import com.rdemir.personelmanagment.model.Job;
import com.rdemir.personelmanagment.model.Personnel;
import com.rdemir.personelmanagment.repository.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonnelService {

    private final PersonnelRepository personnelRepository;
    private final DepartmentService departmentService;
    private final JobService jobService;
    private final AddressService addressService;

    public List<Personnel> getPersonnelList() {
        return personnelRepository.findAll();
    }

    public Personnel getPersonel(Long id) {
        return personnelRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundExceptionHandler("Personel is not found"));
    }

    @Transactional
    public Personnel savePersonnel(Personnel personnel) {
        Department department = departmentService.saveDepartment(personnel.getDepartment());
        personnel.setDepartment(department);
        Personnel personnelResult = personnelRepository.save(personnel);
        List<Address> addressList = personnel.getAddress();
        if (addressList != null && !addressList.isEmpty()) {
            for (Address address : addressList) {
                address.setPersonnel(personnelResult);
                addressService.saveAddress(address);
            }
        }
        return personnelResult;
    }

    public Boolean deletePersonel(Long id) {
        Personnel personnel = getPersonel(id);
        if (personnel == null) {
            throw new NotFoundExceptionHandler("Personnel is not found.");
        }

        List<Address> addressList = personnel.getAddress();
        if (addressList != null && !addressList.isEmpty()) {
            addressList.forEach(address -> {
                addressService.deleteById(address.getId());
            });
        }
        personnelRepository.deleteById(id);
        return true;
    }
}
