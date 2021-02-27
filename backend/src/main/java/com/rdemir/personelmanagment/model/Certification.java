package com.rdemir.personelmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONNEL_CERTICATION")
public class Certification extends BaseEntity{

    private String certicateName;

    private Date certicateDate;

    private String certificationAgency;

    private String certificateDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONNEL_ID")
    private Personnel personnel;
}
