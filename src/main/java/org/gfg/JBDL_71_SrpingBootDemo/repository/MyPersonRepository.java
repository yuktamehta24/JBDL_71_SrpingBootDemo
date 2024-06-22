package org.gfg.JBDL_71_SrpingBootDemo.repository;

import org.gfg.JBDL_71_SrpingBootDemo.model.MyPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Optional;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyPersonRepository extends JpaRepository<MyPerson, Integer> {
}

//public interface MyPersonRepository extends MongoRepository<MyPerson, Integer> {
//}

//public class MyPersonRepository implements JpaRepository<MyPerson, Integer> {
//}

//public class MyPersonRepository extends SimpleJpaRepository<MyPerson, Integer> {
//}
