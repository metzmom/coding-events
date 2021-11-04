package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
  // private static List<String> events = new ArrayList<>();  took this out and replaced with list<Events> to reference
  // new EventData.java class
  // private static List<Event> events = new ArrayList<>();//****this is where we were storing the list.  take
    // ***it out in video 2.4 as we created the EventData class to model the list


    @Autowired//auto populates by spring dependency injection
    private EventRepository eventRepository;
   // commands we want to try:  findAll, save, findById  all methods part of interface
  //to find usage  right click and click on usage






   @GetMapping
   public String displayAllEvents(Model model) {//stores event objects not ideal with models
//      List<String> events = new ArrayList<>();
//      events.add("Wedding");
//      events.add("Engagement Party");
//      events.add("Bachelor Party");
//      events.add("Reception");
      model.addAttribute("title","All Events");
       //model.addAttribute("events", events);//This controller is going
       // to pass in a collection of all events into the template to be displayed.
       // Replace it with the EventData.getAll
     // model.addAttribute("events", EventData.getAll());//calling a static method EventData
       model.addAttribute("events", eventRepository.findAll());//eventRepository.findAll());
       // does same as EventData.getAll()), but done by Springboot


      return "events/index";//need to change this view in index.html


   }
   //lives at /events/create
   @GetMapping("create")
   public String displayCreateEventForm(Model model) {
       model.addAttribute("title", "Create Event");
       model.addAttribute("event", new Event());//will cause id to increment by 2(needs to create event for rendering)
       model.addAttribute("types",EventType.values());
      return "events/create";
   }

   //lives at /events/create
   @PostMapping("create")//create a new event from a form submission

   public String createEvent(@ModelAttribute @Valid Event newEvent,
                             Errors errors, Model model) {//model binding video 2.6
// add for error message to appear on form video 3.2
       if(errors.hasErrors()) {
           model.addAttribute("title", "Create Event");
         //  model.addAttribute("errorMsg", "Bad data! EC called by create.html");
         //  Can remove this with addition of thymeleaf in create.html video 3.3
           return "events/create";
       }

            eventRepository.save(newEvent);
     //  EventData.add(newEvent); this creates and saves a new event object
       //  so need to replace with eventRepository.save(newEvent); and new event will be saved


      // public String createEvent(@RequestParam String eventName,
                         //    @RequestParam String eventDescription) {
      // ***Remove the RequestParam and put in @ModelAttribute Event newEvent)
      // }
       // added eventDescription added in video 2.2
       // events.add(eventName);//take this out as it was a lists of strings but is now a list of objects
       //  events.add(new Event(eventName, eventDescription));//now takes an Event object.creates new event
       // object and passes it to a list // Description added in video 2.2

       //update to reflect the new EventData  video 2.4
       //This can be removed by Model binding video 2.6
       //EventData.add(new Event(eventName, eventDescription));
             return "redirect:";//do not need /events after : as the path is still in events Controller
   }

   @GetMapping("delete")//creating a delete form
   public String displayDeleteEventForm(Model model) {
      model.addAttribute("title", "Delete Events");//gives a title to page
     // model.addAttribute("events", EventData.getAll());//pass in a collection of events
       model.addAttribute("events", eventRepository.findAll());//replace with springboot
      return "events/delete";
   }
   @PostMapping("delete")
   public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {//eventIds must match form
       // element in template

        if (eventIds != null) {//if no boxes are checked
            for (int id : eventIds) {
                eventRepository.deleteById(id);
               // EventData.remove(id); this is replaced by springboot eventRepository.deleteById(id)
            }
        }
           return "redirect:";//normally is path, but we are going to index


   }
}

