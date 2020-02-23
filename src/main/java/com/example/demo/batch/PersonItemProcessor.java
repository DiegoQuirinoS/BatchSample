package com.example.demo.batch;


import org.springframework.batch.item.ItemProcessor;

import com.example.demo.model.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

  @Override
  public Person process(final Person person) throws Exception {
    final String firstName = person.getName().toUpperCase();
    final String lastName = person.getLastName().toUpperCase();
    return  new Person(firstName, lastName);
  }

}