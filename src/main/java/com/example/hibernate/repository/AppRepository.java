package com.example.hibernate.repository;

import com.example.hibernate.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class AppRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    private final static String PERSONS_BY_CITY_SQL =
            "select person from Person person " +
                    "where " +
                    "person.cityOfLiving=:city ";


    public List<Person> getPersonsByCity(String city) {
        return entityManager.
                createQuery(PERSONS_BY_CITY_SQL, Person.class).
                setParameter("city", city).
                getResultList();
    }
}
