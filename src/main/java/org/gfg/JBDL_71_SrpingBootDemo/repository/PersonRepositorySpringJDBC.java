package org.gfg.JBDL_71_SrpingBootDemo.repository;

import lombok.extern.slf4j.Slf4j;
import org.gfg.JBDL_71_SrpingBootDemo.model.Person;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class PersonRepositorySpringJDBC implements IPersonRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    PersonRepositorySpringJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getPersons() {
        log.info("IN GET PERSONS FOR JDBC");
        return jdbcTemplate.query("select * from person",
                new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                log.info("row number: {}", rowNum);
                return new Person(rs.getString("name"), rs.getInt("id"));
            }
        });
    }

    @Override
    public Integer createPerson(Person person) {
        return null;
    }
}
