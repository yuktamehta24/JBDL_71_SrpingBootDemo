package org.gfg.JBDL_71_SrpingBootDemo.service;

import org.gfg.JBDL_71_SrpingBootDemo.model.Person;
import org.gfg.JBDL_71_SrpingBootDemo.repository.IPersonRepository;
import org.gfg.JBDL_71_SrpingBootDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    IPersonRepository ipersonRepository;

    @Autowired
    PersonService(@Qualifier("personRepositorySpringJDBC") IPersonRepository ipersonRepository) {
        this.ipersonRepository = ipersonRepository;
    }

    public List<Person> getPersons() {
        return ipersonRepository.getPersons();
    }

    public Integer createPerson(Person person) {
        return ipersonRepository.createPerson(person);
    }
}
