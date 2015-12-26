package com.gingerik.cv.repository;

import com.gingerik.cv.data.Institute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InstituteRepository extends CrudRepository<Institute, Long> {

    Iterable<Institute> findBySubjectId(@Param("id") Long id);

}