package ru.itcube46.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ru.itcube46.rest.entities.Questions;
import ru.itcube46.rest.entities.Quizzes;
import ru.itcube46.rest.repositories.QuestionsRepository;

@Controller
@RequestMapping(path = "/admin/questions")
public class DesignQuestionController {
    private QuestionsRepository questionsRepository;
    
    public DesignQuestionController(QuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }
    
    @GetMapping(path = "/{id}")
    public String getQuestionForm() {
        return "design-question";
    }

    @PostMapping(path = "/{id}")
    public String addQuestion(@PathVariable("id") Long quizId, Questions question) {
        question.setQuizId(quizId);
        questionsRepository.save(question);
        
        return "redirect:/admin/questions/%d".formatted(quizId);
    }

    @ModelAttribute(name = "question")
    public Questions question() {
        return new Questions();
    }


}
