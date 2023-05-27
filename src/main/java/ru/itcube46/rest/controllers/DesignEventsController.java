package ru.itcube46.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.itcube46.rest.entities.DailyEvents;
import ru.itcube46.rest.entities.LearningVideos;
import ru.itcube46.rest.repositories.DailyEventsRepository;
import ru.itcube46.rest.repositories.LearningVideosRepository;

@Controller
@RequestMapping(path = "/admin/events")
public class DesignEventsController {
    private DailyEventsRepository dailyEventsRepository;
    
    public DesignEventsController(DailyEventsRepository dailyEventsRepository) {
        this.dailyEventsRepository = dailyEventsRepository;
    }
    
    @GetMapping
    public String getEventForm() {
        return "events";
    }

    @PostMapping
    public String addVideo(@ModelAttribute("event") DailyEvents event) {
        dailyEventsRepository.save(event);
        return "home";
    }

    @ModelAttribute(name = "event")
    public DailyEvents dailyEvents() { 
        return new DailyEvents();
    }
    }