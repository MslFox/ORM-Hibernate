package com.example.hibernate.service;

import com.example.hibernate.repository.AppRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AppService {
    private final AppRepository appRepository;

    public String getNameSurnameByCityAgeOrder(String city) {
        var resultList = appRepository.getPersonsByCity(city);
        return resultList.isEmpty() ? "NO PERSONS FROM " + city.toUpperCase() + "!" :
                String.format("PERSONS FROM %s:\n%s",
                        city.toUpperCase(),
                        resultList.stream().
                                map(x -> x.getPersonShortData().nameSurnameToUpperCaseString()).
                                collect(Collectors.joining("\n")));
    }

    public String getNameSurnameByAgeLessThan(int age) {
        var resultList = appRepository.getPersonByAgeLessThan(age);
        return resultList.isEmpty() ? "NO PERSONS YOUNGER THAN " + age + "!" :
                String.format("PERSONS YOUNGER THAN %s:\n%s",
                        age,
                        resultList.stream().
                                map(x -> x.getPersonShortData().nameSurnameToUpperCaseString()).
                                collect(Collectors.joining("\n")));
    }
    public String getPersonByNameSurname(String name, String surname) {
        try{
        var person = appRepository.getPersonByNameAndSurname(name, surname).
                orElseThrow(() -> new EntityNotFoundException("PERSON NOT FOUND"));
                return String.format("%s %s Возраст: %s Тел: %s Город: %s",
                        person.getPersonShortData().getName(),
                        person.getPersonShortData().getSurname(),
                        person.getPersonShortData().getAge(),
                        person.getPhoneNumber(),
                        person.getCity().getName());
    }catch (EntityNotFoundException e){
            return e.getMessage();
        }
    }
}
