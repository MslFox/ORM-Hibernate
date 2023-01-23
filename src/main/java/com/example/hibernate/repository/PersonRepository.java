package com.example.hibernate.repository;

import com.example.hibernate.entities.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    @Query("select p from Person p " +
            "join City c on c.id = p.city.id " +
            "where c.name=:city")
    List<Person> findByCityName(@Param("city") String name);

    @Query("select p from Person p " +
            "where p.personShortData.age <:ds ")
    List<Person> findByPersonShortDataAgeLessThan(@Param("ds") int age, Sort sort);
    @Query("select p from Person p " +
            "where p.personShortData.name=:name " +
            "and p.personShortData.surname=:surname")
    Optional<Person> findByPersonShortDataNameAndPersonShortDataSurname(@Param("name") String name, @Param("surname") String surname);

}
