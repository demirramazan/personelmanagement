package com.rdemir.personelmanagment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rdemir.personelmanagment.enums.EducationalStatus;
import com.rdemir.personelmanagment.enums.GraduationStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "PERSONNEL_EDUCATIONAL")
public class Education extends BaseEntity {

    private String schoolName;
    private String schoolCity;
    private Integer startYear;
    private Integer graduateYear;
    private Double gradeAvarege;
    private String university;
    private String faculty;
    private String department;
    private String universityCity;

    @Enumerated(EnumType.STRING)
    private EducationalStatus educationalStatus;
    @Enumerated(EnumType.STRING)
    private GraduationStatus graduationStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONNEL_ID")
    private Personnel personnel;

}
