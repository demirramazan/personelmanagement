package com.rdemir.personelmanagment;

import com.rdemir.personelmanagment.enums.AddressType;
import com.rdemir.personelmanagment.enums.Gender;
import com.rdemir.personelmanagment.enums.MaritalStatus;
import com.rdemir.personelmanagment.enums.MilitaryStatus;
import com.rdemir.personelmanagment.model.Address;
import com.rdemir.personelmanagment.model.Department;
import com.rdemir.personelmanagment.model.Personnel;
import com.rdemir.personelmanagment.repository.PersonnelRepository;
import com.rdemir.personelmanagment.service.PersonnelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseLoader implements CommandLineRunner {

    private final PersonnelService personnelService;


    @Override
    public void run(String... strings) throws Exception {
        List<Address> addressList = new ArrayList<>();
        Address address = Address.builder().addressType(AddressType.HOME).city("Ankara")
                .district("Karapürçek Mah").country("Türkiye").adressDetail("Akcity Konutları B blok")
                .doorNo("3").street("497 sok").build();
        addressList.add(address);

        Department department = Department.builder().departmentName("Yazılım Geliştirme").build();

        Personnel personnel = Personnel.builder().firstName("Ramazan").lastName("Demir").identityNumber("36265907884")
             .birthPlace("Malatya").maritalStatus(MaritalStatus.MARRIED)
                .bloodGroup("0 Rh +").gender(Gender.MALE).email("asd@asd.com").militaryStatus(MilitaryStatus.DONE)
                .driverLicence("B").address(addressList).department(department).build();

        this.personnelService.savePersonnel(personnel);
    }
}