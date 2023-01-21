package com.example.hibernate.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PersonShortData implements Serializable {
    private String name;
    private String surname;
    private int age;

    public String nameSurnameToUpperCaseString() {
        return name.toUpperCase() + " " + surname.toUpperCase();
    }

}
