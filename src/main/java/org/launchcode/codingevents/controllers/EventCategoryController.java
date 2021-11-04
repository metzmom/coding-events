package org.launchcode.codingevents.controllers;


import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired//auto populates by spring dependency injection
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll());
        return "eventCategories/index";//need to change this view in index.html
    }
    @GetMapping("create")
    public String renderCreateEventCategoryForm (Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute( new EventCategory());//will cause id to increment by 2(needs to create event for rendering)
        return "eventCategories/create";
    }


    @PostMapping("create")
    public String processCreateEventCategoryForm(@Valid @ModelAttribute EventCategory eventCategory,
                Errors errors, Model model){
            if (errors.hasErrors()) {
                model.addAttribute("title", "Create Category");
                model.addAttribute( new EventCategory());
                //  model.addAttribute("errorMsg", "Bad data! EC called by create.html");
                //  Can remove this with addition of thymeleaf in create.html video 3.3
            return "eventCategories/create";
            }

            eventCategoryRepository.save(eventCategory);
            return "redirect:";
        }
}
