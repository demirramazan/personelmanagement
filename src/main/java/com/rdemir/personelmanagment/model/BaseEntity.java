package com.rdemir.personelmanagment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @CreatedDate
    private LocalDateTime createDate;

    @PrePersist
    private void onCreateDate() {
        createDate = LocalDateTime.now();
    }

    @LastModifiedDate
    private LocalDateTime updateDate;

    @PreUpdate
    private void onUpdate(){
        updateDate=LocalDateTime.now();
    }
}
