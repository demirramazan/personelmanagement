package com.rdemir.personelmanagment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "PERSONNEL_ADDRESS")
public class Address extends BaseEntity {

    private String country;
    private String city;
    private String district;
    private String street;
    private String doorNo;
    private String adressDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONNEL_ID")
    @JsonIgnore
    private Personnel personnel;


}
