package com.kuehne.nagel.test.contactlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String url;

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", url='" + url + '\'' +
            '}';
    }
}
