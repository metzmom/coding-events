package org.launchcode.codingevents.models;

public class Event {
    private String name;
//all of this was made with the generator.right click and choose generator
    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
