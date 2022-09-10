package com.kuehne.nagel.test.contactlist.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class PersonDTO {

    private final String name;

    private final String url;

    public PersonDTO(final String name,
                     final String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
            "name='" + name + '\'' +
            ", url='" + url + '\'' +
            '}';
    }

}
