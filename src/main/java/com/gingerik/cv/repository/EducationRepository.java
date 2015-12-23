package com.gingerik.cv.repository;

import com.gingerik.cv.data.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EducationRepository extends CrudRepository<Education, Long> {

    public Iterable<Education> findByInstituteId(@Param("id") Long id);
    public Iterable<Education> findByInstituteSubjectId(@Param("id") Long id);

}