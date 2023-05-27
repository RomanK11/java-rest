package ru.itcube46.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ru.itcube46.rest.entities.Questions;
import ru.itcube46.rest.entities.Quizzes;
import ru.itcube46.rest.repositories.QuestionsRepository;
import ru.itcube46.rest.repositories.QuizzesRepository;

@Controller
@RequestMapping(path = "/admin")
public class HomePageController {

    @GetMapping
    public String getHome() {
        return "home";
    }
}
