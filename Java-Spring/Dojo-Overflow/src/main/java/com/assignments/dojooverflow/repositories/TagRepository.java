package com.assignments.dojooverflow.repositories;

import com.assignments.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    Optional<Tag> findBySubject(String subject);
}
