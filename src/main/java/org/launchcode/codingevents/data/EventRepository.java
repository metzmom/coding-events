package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository//tells springboot to manage this class  see in eventCController via autowired
public interface EventRepository extends CrudRepository<Event, Integer>{
}
//crudRepost allows us to store and retrieve data from db
// Springboot will automatically create a class like:
// public class MyRepository implements EventRepository in memory
// so, it can be autowired into the EventController eventRepository field

