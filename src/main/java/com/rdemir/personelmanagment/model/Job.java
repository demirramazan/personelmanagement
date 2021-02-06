package com.rdemir.personelmanagment.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Job  extends BaseEntity{

    private String jobName;

}
