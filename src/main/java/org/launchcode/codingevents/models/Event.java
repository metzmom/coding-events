package org.launchcode.codingevents.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Event {
    //video 2.4 assigning a unique identifier
    private int id;//private id field.Private so no one can edit
    private static int nextId = 1;//static counter  belongs to class,
    // not any single object. so every new object will be upped by one and be unique
    // see public constructor





    @NotBlank(message = "Name is required.")
    @Size (min = 3, max = 50,message = "Name must be between 3 and 50 characters")
    private String name;//this name must match on forms in create.html video 6


    @Size(max = 500, message = "Description too long!")//validation added video 7
    private String description;//this name must match on forms in create.html

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again.")//add email video 7
    private String contactEmail;


//all of this was made with the generator.right click and choose generator
    public Event(String name, String description, String contactEmail) {//added contact email in video 7
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;//added to constructor in video 7
        this.id = nextId;//video 2.3  constructor for id and increments id
        nextId++;

    }
    public Event(){}

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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {//add get/set for contactEmail
        this.contactEmail = contactEmail;
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
