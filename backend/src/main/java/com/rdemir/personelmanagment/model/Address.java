package com.rdemir.personelmanagment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rdemir.personelmanagment.enums.AddressType;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSONNEL_ADDRESS")
@Builder
public class Address extends BaseEntity {

    private String country;
    private String city;
    private String district;
    private String street;
    private String doorNo;
    private String adressDetail;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONNEL_ID")
    @JsonIgnore
    private Personnel personnel;

}
