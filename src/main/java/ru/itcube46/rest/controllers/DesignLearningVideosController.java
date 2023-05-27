package ru.itcube46.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.itcube46.rest.entities.LearningVideos;
import ru.itcube46.rest.repositories.LearningVideosRepository;

@Controller
@RequestMapping(path = "/admin/learning-videos")
public class DesignLearningVideosController {
    private LearningVideosRepository learningVideosRepository;
    
    public DesignLearningVideosController(LearningVideosRepository learningVideosRepository) {
        this.learningVideosRepository = learningVideosRepository;
    }
    
    @GetMapping
    public String getVideosForm() {
        return "learning-videos";
    }

    @PostMapping
    public String addVideo(@ModelAttribute("video") LearningVideos learningVideo) {
        learningVideosRepository.save(learningVideo);
        return "home";
    }

    @ModelAttribute(name = "video")
    public LearningVideos learningVideo() { 
        return new LearningVideos();
    }
    }