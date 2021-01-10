package com.assignments.license.repositories;

import com.assignments.license.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    License findTopByOrderByNumberDesc();
}
