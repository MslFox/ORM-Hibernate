package com.example.hibernate.repository;

import com.example.hibernate.entities.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findByCityName(String name);

    List<Person> findByPersonShortDataAgeLessThan(int age, Sort sort);

    Optional<Person> findByPersonShortDataNameAndPersonShortDataSurname(String name, String surname);

}
