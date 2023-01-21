package com.example.hibernate.service;

import com.example.hibernate.repository.AppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AppService {
    private final AppRepository appRepository;

    public String getNameSurnameByCityAgeOrder(String city) {
//        return appRepository.getPersonsByCity(city).stream().
//                map(x -> x.getPersonNameSurnameAge().nameSurnameToUpperCaseString()).
//                collect(Collectors.joining("\n"));
        var resultList = appRepository.getPersonsByCity(city);
        return resultList.isEmpty() ? "NO PERSONS FROM " + city.toUpperCase() + "!" :
                String.format("PERSONS FROM %s:\n%s",
                        city.toUpperCase(),
                        resultList.stream().
                                map(x -> x.getPersonNameSurnameAge().nameSurnameToUpperCaseString()).
                                collect(Collectors.joining("\n")));

    }
}
