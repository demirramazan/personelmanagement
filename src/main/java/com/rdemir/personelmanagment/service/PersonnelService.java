package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.model.Address;
import com.rdemir.personelmanagment.model.Department;
import com.rdemir.personelmanagment.model.Job;
import com.rdemir.personelmanagment.model.Personnel;
import com.rdemir.personelmanagment.repository.AddressRepository;
import com.rdemir.personelmanagment.repository.DepartmentRepository;
import com.rdemir.personelmanagment.repository.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonnelService {

    private final PersonnelRepository personnelRepository;
    private final AddressRepository addressRepository;
    private final DepartmentService departmentService;
    private final JobService jobService;
    private final AddressService addressService;

    public List<Personnel> getPersonnelList() {
        return personnelRepository.findAll();
    }

    public Personnel getPersonel(Long id) {
        return personnelRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Personel is not found"));
    }

    @Transactional
    public Personnel savePersonnel(Personnel personnel) {
        Department department=  departmentService.saveDepartment(personnel.getDepartment());
        Job job=  jobService.saveJob(personnel.getJob());
        personnel.setDepartment(department);
        personnel.setJob(job);
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
}
