package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//class for storing event objects
public class EventData {
//need a place to put my events. static only one, declared to be type map,
  //  map interface allows key /value pairs. Map object will store integer event pairs,
  //  integers are the ids. will be easier to retrieve using ID, by just giving it it's id
// ****  new hash maps will be run when first loaded into memory
    private static final Map<Integer, Event> events = new HashMap<>();
    //added final, meanings that the map cannot change.adds some security
//*** all methods are static and public

   // This is encapsulation: so no one else knows how it is stored. meaning when you change
   // something in a class how would it effect other things in other classes.you want to reduce the impact
   // of those changes
//***will return all events
    public static Collection<Event> getAll() {//will return a list of events
        return events.values();//want all values only values
        //collection is an interface gives loop behavior.
    }
//***add an event to our list
    //add an event by getting id, then the event itself
    public static void add(Event event) {//void  does not return anything
        events.put(event.getId(), event);
        //in my map putting in key value pair, key is id value is object itself
    }
//***get a single event  all static:want a collection of methods
    public static Event getById(Integer id) {
        return events.get(id);// want to retrieve item with the key with the id that is passed in
    }
//***remove an event
    public static void remove(Integer id) {//need to know id to remove
        if (events.containsKey(id)) {//after you put a . after an object, IntelliJ gives suggestions
            events.remove(id);//extracts a single event from event map

        }
    }//*****need to add to event controller to use this class



}
