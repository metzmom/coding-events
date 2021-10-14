package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
  // private static List<String> events = new ArrayList<>();  took this out and replaced with list<Events> to reference
  // new Event.java class
  // private static List<Event> events = new ArrayList<>();//****this is where we were storing the list.  take
    // ***it out in video 2.4 as we created the EventData class to model the list
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
       model.addAttribute("events", EventData.getAll());//calling a static method EventData
      return "events/index";//need to change this view in index.html


   }
   //lives at /events/create
   @GetMapping("create")
   public String displayCreateEventForm() {
      return "events/create";
   }

   //lives at /events/create
   @PostMapping("create")//create a new event from a form submission
   public String createEvent(@RequestParam String eventName,
                             @RequestParam String eventDescription) {//added event
       // Description added in video 2.2
       // events.add(eventName);//take this out as it was a lists of strings but is now a list of objects
       //  events.add(new Event(eventName, eventDescription));//now takes an Event object.creates new event
       // object and passes it to a list // Description added in video 2.2

       //update to reflect the new EventData  video 2.4
       EventData.add(new Event(eventName, eventDescription));
       return "redirect:";//do not need /events after : as the path is still in events Controller
   }

   @GetMapping("delete")//creating a delete form
   public String displayDeleteEventForm(Model model) {
      model.addAttribute("title", "Delete Events");//gives a title to page
      model.addAttribute("events", EventData.getAll());//pass in a collection of events
      return "events/delete";
   }
   @PostMapping("delete")
   public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {//eventIds must match form
       // element in template

        if (eventIds != null) {//if no boxes are checked
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
           return "redirect:";//normally is path, but we are going to index


   }
}

