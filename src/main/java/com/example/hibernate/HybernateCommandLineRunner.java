package com.example.hibernate;

import com.example.hibernate.entities.Person;
import com.example.hibernate.entities.PersonNameSurnameAge;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class HybernateCommandLineRunner implements CommandLineRunner {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var names = List.of("Ivan", "Petr", "Alexey", "Igor", "Semen");
        var surnames = List.of("Petrov", "Vasiliev", "Mikhailov", "Serov", "Semenov");
        var ages = List.of(34, 34, 24, 45, 38);
        IntStream.range(0, 5).
                forEach(i -> {
                    var personNameSurnameAge = PersonNameSurnameAge.builder().
                            name(names.get(i)).
                            surname(surnames.get(i)).
                            age(ages.get(i)).
                            build();
                    var person = Person.builder().
                            personNameSurnameAge(personNameSurnameAge).
                            phoneNumber("900800777" + i).
                            cityOfLiving(i % 2 == 0 ? "Moscow" : "Saint Petersburg").
                            build();
                    entityManager.persist(person);
                });
    }
}
