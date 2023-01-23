package com.example.hibernate.repository;

import com.example.hibernate.entities.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class AppRepository {
    private final PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCityName(city);
    }

    public List<Person> getPersonByAgeLessThan(int age) {
        return personRepository.findByPersonShortDataAgeLessThan(age, Sort.by("personShortData.age"));
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findByPersonShortDataNameAndPersonShortDataSurname(name, surname);
    }

}
