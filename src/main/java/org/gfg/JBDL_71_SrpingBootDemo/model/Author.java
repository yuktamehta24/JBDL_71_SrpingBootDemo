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
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customGenerator")
//    @TableGenerator(name = "authorGenerator")

//    @GeneratedValue(strategy = GenerationType.TABLE)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "fName", length = 20)
    String name;

    public Author(String name) {
        this.name = name;
    }
}
