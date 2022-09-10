package com.kuehne.nagel.test.contactlist.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Contact {

    private final String name;

    private final String imageUrl;

    public Contact(final String name,
                   final String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "Contact{" +
            "name='" + name + '\'' +
            ", url='" + imageUrl + '\'' +
            '}';
    }

}
