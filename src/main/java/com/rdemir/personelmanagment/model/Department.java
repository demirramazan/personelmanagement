package com.rdemir.personelmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department  extends BaseEntity{

    private String departmentName;

}
