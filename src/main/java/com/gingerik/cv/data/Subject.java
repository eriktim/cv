package com.gingerik.cv.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Subject {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String residence;
    private String nationality;
    private @Column(columnDefinition = "TEXT") String ambition;

    private Subject() {}

    public Subject(String firstName,
                   String lastName,
                   Date dateOfBirth,
                   String residence,
                   String nationality,
                   String ambition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.residence = residence;
        this.nationality = nationality;
        this.ambition = ambition;
    }
}