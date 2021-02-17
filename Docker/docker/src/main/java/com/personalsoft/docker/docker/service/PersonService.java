package com.personalsoft.docker.docker.service;

import com.personalsoft.docker.docker.dao.PersonDAO;
import com.personalsoft.docker.docker.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public Person save (Person person){
        return  personDAO.save(person);
    }

    public Person update (Person person){
        return personDAO.save(person);
    }

    public void delete (Person person){
        personDAO.delete(person);
    }

    public Iterable<Person> list(){
        return personDAO.findAll();
    }

    public Optional<Person> listById(int id){
        return personDAO.findById(id);
    }
}
