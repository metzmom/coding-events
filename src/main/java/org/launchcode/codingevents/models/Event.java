package org.launchcode.codingevents.models;

import java.util.Objects;

public class Event {
    //video 2.4 assigning a unique identifier
    private int id;//private id field.Private so no one can edit
    private static int nextId = 1;//static counter  belongs to class,
    // not any single object. so every new object will be upped by one and be unique
    // see public constructor

    private String name;//this name must match on forms in create.html video 6
    private String description;//this name must match on forms in create.html


//all of this was made with the generator.right click and choose generator
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        this.id = nextId;//video 2.3  constructor for id and increments id
        nextId++;
    }
    public int getId() {//no setter...do not want anyone to change.
        return id;
        // No get/set for nextId since private and we want no one to change it
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   @Override
   public String toString() {
        return  name ;
    }
    //need hashcode whenever you crate own Java objects:
    //use auto generator by right clicking

    @Override// video 2.3
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override//video 2.3
    public int hashCode() {
        return Objects.hash(id);
    }
}
