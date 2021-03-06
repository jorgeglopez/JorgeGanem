package com.personalsoft.docker.docker.dao;

import com.personalsoft.docker.docker.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends CrudRepository<Person, Integer> {

}
