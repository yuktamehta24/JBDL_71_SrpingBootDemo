package org.gfg.JBDL_71_SrpingBootDemo.repository;

import lombok.extern.slf4j.Slf4j;
import org.gfg.JBDL_71_SrpingBootDemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class PersonRepository implements IPersonRepository {

//    @Autowired
    Connection connection;

//    PersonRepository() {
//        createTable();
//    }

    @Autowired
    PersonRepository(Connection connection) {
        this.connection = connection;
        createTable();
    }

    public List<Person> getPersons() {
        log.info("In core person repository");
        List<Person> personList = new ArrayList<>();
        try {
            ResultSet resultSet = connection.createStatement()
                    .executeQuery("select * from person");
            while (resultSet.next()) {
                Person person = new Person(resultSet.getString("name"),
                        resultSet.getInt("id"));
                personList.add(person);
            }
            return personList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer createPerson(Person person) {
        try {

            boolean initialautocommit = connection.getAutoCommit();
//            return connection.createStatement().executeUpdate
//                    ("insert into person (name, id) values ('"
//                            + person.getName() + "', " + person.getId() + ");");

            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into person (id, name) values (?, ?)");
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            int result =  preparedStatement.executeUpdate();
            log.info("result is: {}", result);
            connection.commit();

            connection.setAutoCommit(initialautocommit);
            return result;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    private void createTable() {
        try {
            connection.createStatement()
                    .executeUpdate("create table if not exists person (name varchar(20), id int)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
