package org.launchcode.codingevents.controllers;

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
  // private static List<String> events = new ArrayList<>();  took this out and replaced with list<Events> to reference new Event.java class
   private static List<Event> events = new ArrayList<>();
   @GetMapping
   public String displayAllEvents(Model model) {
//      List<String> events = new ArrayList<>();
//      events.add("Wedding");
//      events.add("Engagement Party");
//      events.add("Bachelor Party");
//      events.add("Reception");
      model.addAttribute("title","AllEvents");
      model.addAttribute("events", events);
      return "events/index";//need to change this view in index.html


   }
   //lives at /events/create
   @GetMapping("create")
   public String displayCreateEventForm() {
      return "events/create";
   }
   //lives at /events/create
   @PostMapping("create")
   public String createEvent(@RequestParam String eventName){
     // events.add(eventName);//take this out as it was a lists of strings but is now a list of objects
      events.add(new Event(eventName));//now takes an Event object.creates new event object and passes it to a list
      return "redirect:";//do not need /events after : as the path is still in events Controller




   }
}

