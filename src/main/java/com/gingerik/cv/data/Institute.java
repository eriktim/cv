package com.gingerik.cv.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Institute {

    private @Id @GeneratedValue Long id;
    private @ManyToOne
    Subject subject;
    private String name;
    private String logo;

    private Institute() {}

    public Institute(Subject subject,
                     String name,
                     String logo) {
        this.subject = subject;
        this.name = name;
        this.logo = logo;
    }
}