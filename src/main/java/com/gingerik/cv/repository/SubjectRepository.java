package com.gingerik.cv.repository;

import com.gingerik.cv.data.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

    public Iterable<Subject> findByLastNameContainingIgnoreCase(String lastName);

}