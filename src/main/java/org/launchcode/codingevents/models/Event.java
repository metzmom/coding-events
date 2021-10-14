package org.launchcode.codingevents.models;

public class Event {
    private String name;
    private String description;


//all of this was made with the generator.right click and choose generator
    public Event(String name, String description) {
        this.name = name;
        this.description = description;
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
}
