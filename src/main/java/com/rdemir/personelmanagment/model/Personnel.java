package com.rdemir.personelmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONNEL")
public class Personnel extends BaseEntity {

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date birthDay;

    private String birthPlace;

    private Double salary;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Enumerated(EnumType.STRING)
    private MilitaryStatus militaryStatus;

    @Temporal(TemporalType.DATE)
    private Date dischargeDate;

    @Size(min = 11, max = 11, message = "Personel IdentityNumber is  size 11")
    private String identityNumber;

    @Lob
    private Byte image;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    @OneToOne
    @JoinColumn(name = "JOB_ID")
    private Job job;

    @OneToMany(mappedBy = "personnel", fetch = FetchType.EAGER)
    private List<Address> address;

}
