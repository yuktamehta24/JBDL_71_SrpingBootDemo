package org.gfg.JBDL_71_SrpingBootDemo.controller;

import org.gfg.JBDL_71_SrpingBootDemo.exception.CustomException;
import org.gfg.JBDL_71_SrpingBootDemo.model.Person;
import org.gfg.JBDL_71_SrpingBootDemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

//    @Autowired
    PersonService personService;

    @Autowired
    PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        // validations
        // return the correct response fetched from service
        return personService.getPersons();
    }

    @PostMapping("/person")
    public Integer createPerson(@RequestBody Person person) throws CustomException {
        if (person.getName() == null || person.getId() == null) {
            throw new IllegalArgumentException("Mandatory parameters are null");
        }
        return personService.createPerson(person);
    }
}
