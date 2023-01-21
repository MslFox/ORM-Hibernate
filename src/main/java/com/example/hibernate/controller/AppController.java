package com.example.hibernate.controller;


import com.example.hibernate.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class AppController {
    private final AppService appService;

    @GetMapping("/persons/by-city")
    public ResponseEntity<String> getResponse(@RequestParam String city ) {
        return ResponseEntity.ok().
                contentType(MediaType.TEXT_PLAIN).
                body(appService.getNameSurnameByCityAgeOrder(city));
    }
    @GetMapping("/persons/by-age")
    public ResponseEntity<String> getResponse(@RequestParam Integer age ) {
        return ResponseEntity.ok().
                contentType(MediaType.TEXT_PLAIN).
                body(appService.getNameSurnameByAgeLessThan(age));
    }
    @GetMapping("persons/by-name-surname")
    public ResponseEntity<String> getResponse(@RequestParam String name, String surname) {
        return ResponseEntity.ok().
                body(appService.getPersonByNameSurname(name, surname));
    }


}
