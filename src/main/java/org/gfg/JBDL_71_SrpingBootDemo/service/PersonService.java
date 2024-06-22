package org.gfg.JBDL_71_SrpingBootDemo.service;

import lombok.extern.slf4j.Slf4j;
import org.gfg.JBDL_71_SrpingBootDemo.model.MyPerson;
import org.gfg.JBDL_71_SrpingBootDemo.model.Person;
import org.gfg.JBDL_71_SrpingBootDemo.repository.IPersonRepository;
import org.gfg.JBDL_71_SrpingBootDemo.repository.MyPersonRepository;
import org.gfg.JBDL_71_SrpingBootDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {

    IPersonRepository ipersonRepository;

    MyPersonRepository myPersonRepository;

    @Autowired
    PersonService(@Qualifier("personRepositorySpringJDBC") IPersonRepository ipersonRepository,
                  MyPersonRepository myPersonRepository) {
        this.ipersonRepository = ipersonRepository;
        this.myPersonRepository = myPersonRepository;
    }

    public List<Person> getPersons() {
        return ipersonRepository.getPersons();
    }

    public Integer createPerson(Person person) {
//        return ipersonRepository.createPerson(person);

        MyPerson myPerson = new MyPerson(person.getName());
        MyPerson addedRecord = myPersonRepository.save(myPerson);
        //findById
        //findAll
        log.info("added record is: {}", addedRecord);
        return 1;
    }
}
