package com.rdemir.personelmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONNEL")
public class Personnel extends BaseEntity {

    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthDay;
    private Double salary;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private String email;

    private String identityNumber;


    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @OneToOne
    @JoinColumn(name = "JOB_ID")
    private Job job;
//
    @OneToMany(mappedBy = "personnel", fetch = FetchType.EAGER)
    private List<Address> address;


}
