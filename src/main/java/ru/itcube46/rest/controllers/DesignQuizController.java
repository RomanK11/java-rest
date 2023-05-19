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
@RequestMapping(path = "/admin/quiz")
public class DesignQuizController {
    private QuizzesRepository quizzesRepository;
    private QuestionsRepository questionsRepository;

    public DesignQuizController(QuizzesRepository quizzesRepository, QuestionsRepository questionsRepository) {
        this.quizzesRepository = quizzesRepository;
        this.questionsRepository = questionsRepository;
    }

    @GetMapping
    public String getQuizForm() {
        return "design-quiz";
    }

    @PostMapping
    public String addQuizz(Quizzes quizz) {
        quizzesRepository.save(quizz);
        return "redirect:/admin/questions/%d".formatted(quizz.getId());
    }

    @ModelAttribute(name = "quizz")
    public Quizzes quizz() {
        return new Quizzes();
    }

    // @GetMapping("/add-question")
    // public String getQuestionForm() {
    //     return "design-question";
    // }

    
    // @PostMapping
    // public String addQuestion(Questions question) {
    //     questionsRepository.save(question);
    //     return "home";
    // }

    // @ModelAttribute(name = "question")
    // public Questions question() {
    //     return new Questions();
    // }


}
