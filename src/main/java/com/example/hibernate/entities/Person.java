package com.example.hibernate.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "persons")
public class Person {

    @EmbeddedId
    private PersonNameSurnameAge personNameSurnameAge;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String cityOfLiving;

}
