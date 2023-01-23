package com.example.hibernate;

import com.example.hibernate.entities.City;
import com.example.hibernate.entities.Person;
import com.example.hibernate.entities.PersonShortData;
import com.example.hibernate.repository.CityRepository;
import com.example.hibernate.repository.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class HybernateCommandLineRunner implements CommandLineRunner {
    private final PersonRepository personRepository;
    private final CityRepository cityRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var names = List.of("Alexey", "Igor");
        var surnames = List.of("Petrov", "Vasiliev", "Mikhailov", "Serov", "Semenov");
        var ages = List.of(34, 54, 24, 45, 38);
        var cities = Stream.of("Moscow", "Saint Petersburg").
                map(n -> City.builder().
                        name(n).
                        build()).
                peek(cityRepository::save).
                toList();
        IntStream.range(0, 5).
                mapToObj(i -> Person.builder().
                        personShortData(PersonShortData.builder().
                                name(names.get(i % 2 == 0 ? 0 : 1)).
                                surname(surnames.get(i)).
                                age(ages.get(i)).
                                build()).
                        phoneNumber("900800777" + i).
                        city(cities.get(i % 2 == 0 ? 0 : 1)).
                        build()).
                forEach(personRepository::save);
    }
}
