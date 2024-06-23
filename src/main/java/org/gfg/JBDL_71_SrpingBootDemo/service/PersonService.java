package org.gfg.JBDL_71_SrpingBootDemo.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.gfg.JBDL_71_SrpingBootDemo.exception.CustomException;
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
    PersonService(@Qualifier("personRepository") IPersonRepository ipersonRepository,
                  MyPersonRepository myPersonRepository) {
        this.ipersonRepository = ipersonRepository;
        this.myPersonRepository = myPersonRepository;
    }

    public List<Person> getPersons() {
        return ipersonRepository.getPersons();
    }

    @Transactional(rollbackOn = {CustomException.class})
    public Integer createPerson(Person person) throws CustomException {
//        return ipersonRepository.createPerson(person);

        MyPerson myPerson = new MyPerson(person.getName());
        MyPerson addedRecord = myPersonRepository.save(myPerson);

        if (person.getName().equalsIgnoreCase("yukta")) {
            throw new CustomException("invalid name");
        }

        log.info("added record is: {}", addedRecord);
        return 1;
    }
}
