package com.rdemir.personelmanagment.model;

import com.rdemir.personelmanagment.enums.JobType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONNEL_JOB")
public class Job extends BaseEntity {

    @Column(length = 50)
    private String jobName;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    private String jobDescription;

    @Enumerated(value = EnumType.STRING)
    private JobType jobType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONNEL_ID")
    private Personnel personnel;

}
