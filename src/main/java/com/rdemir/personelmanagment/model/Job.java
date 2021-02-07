package com.rdemir.personelmanagment.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Job  extends BaseEntity{

    @Column(length = 50)
    private String jobName;

}
