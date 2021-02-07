package com.rdemir.personelmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "PERSONNEL_FOREIGN_LANGUAGE")
public class ForeignLanguage extends BaseEntity {

    private String language;

    private Integer readLevel;

    private Integer listeningLevel;

    private Integer writingLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONNEL_ID")
    private Personnel personnel;
}
