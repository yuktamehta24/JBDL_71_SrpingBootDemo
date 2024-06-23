package org.gfg.JBDL_71_SrpingBootDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MyPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @TableGenerator(name = "myPersonGenerator")
//
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
//    @TableGenerator(
//            name = "customGenerator",
//            initialValue = 9,
//            allocationSize = 1
//    )
//    @GeneratedValue(strategy = GenerationType.TABLE)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "fName", length = 20)
    String name;

    public MyPerson(String name) {
        this.name = name;
    }
}

//no strategy
//drop table if exists MyPerson
//create table MyPerson (id integer not null, fName varchar(20), primary key (id)) engine=InnoDB

//identifier strategy
//drop table if exists MyPerson
//create table MyPerson (id integer not null auto_increment, fName varchar(20), primary key (id)) engine=InnoDB

//UUID strategy
//drop table if exists MyPerson
//create table MyPerson (fName varchar(20), id varchar(255) not null, primary key (id)) engine=InnoDB

//Table strategy
//Hibernate: drop table if exists hibernate_sequences
//Hibernate: drop table if exists MyPerson
//Hibernate: create table hibernate_sequences (next_val bigint, sequence_name varchar(255) not null, primary key (sequence_name)) engine=InnoDB
//Hibernate: insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
//Hibernate: create table MyPerson (id integer not null, fName varchar(20), primary key (id)) engine=InnoDB

//Table strategy with custom generator
//Hibernate: drop table if exists MyPerson
//Hibernate: drop table if exists `table-generator`
//Hibernate: create table MyPerson (id integer not null, fName varchar(20), primary key (id)) engine=InnoDB
//Hibernate: create table `table-generator` (next_val bigint, sequence_name varchar(255) not null, primary key (sequence_name)) engine=InnoDB
//Hibernate: insert into `table-generator`(sequence_name, next_val) values ('MyPerson',9)

//Sequence strategy
//Hibernate: drop table if exists MyPerson
//Hibernate: drop table if exists MyPerson_SEQ
//Hibernate: create table MyPerson (fName varchar(20), id varchar(255) not null, primary key (id)) engine=InnoDB
//Hibernate: create table MyPerson_SEQ (next_val bigint) engine=InnoDB
//Hibernate: insert into MyPerson_SEQ values ( 1 )