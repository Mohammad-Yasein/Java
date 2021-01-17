package com.assignments.events.repositories;

import com.assignments.events.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByState(String state);

    List<Event> findByStateIsNot(String state);
}
