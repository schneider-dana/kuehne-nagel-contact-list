package com.kuehne.nagel.test.contactlist.repository;

import com.kuehne.nagel.test.contactlist.model.Person;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByName(final String name);

}
