package org.gfg.JBDL_71_SrpingBootDemo.repository;

import org.gfg.JBDL_71_SrpingBootDemo.model.Person;

import java.util.List;

public interface IPersonRepository {

    List<Person> getPersons();

    Integer createPerson(Person person);
}
