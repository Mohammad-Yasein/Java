package com.assignments.dojoninjas.repositories;

import com.assignments.dojoninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
}
