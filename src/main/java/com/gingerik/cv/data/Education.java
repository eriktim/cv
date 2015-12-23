package com.gingerik.cv.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Education {

    private @Id @GeneratedValue Long id;
    private @ManyToOne Institute institute;
    private Date start;
    private @Column(nullable = true) Date end;
    private @Column(columnDefinition = "TEXT") String description;
    private Boolean complete;

    private Education() {}

    public Education(Institute institute,
                     Date start,
                     Date end,
                     String description,
                     Boolean complete) {
        this.institute = institute;
        this.start = start;
        this.end = end;
        this.description = description;
        this.complete = complete;
    }
}