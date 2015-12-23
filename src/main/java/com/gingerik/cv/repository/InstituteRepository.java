package com.gingerik.cv.repository;

import com.gingerik.cv.data.Institute;
import com.gingerik.cv.data.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InstituteRepository extends CrudRepository<Institute, Long> {

    public Iterable<Institute> findBySubjectId(@Param("id") Long id);

}