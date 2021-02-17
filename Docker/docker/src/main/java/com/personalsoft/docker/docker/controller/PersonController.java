package com.personalsoft.docker.docker.controller;

import com.personalsoft.docker.docker.model.Person;
import com.personalsoft.docker.docker.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/save")
    public int save(@RequestBody Person person){
        personService.save(person);
        return person.getIdPerson();
    }
}
