package com.rdemir.personelmanagment.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department  extends BaseEntity{

    @Column(length = 50)
    private String departmentName;

}
