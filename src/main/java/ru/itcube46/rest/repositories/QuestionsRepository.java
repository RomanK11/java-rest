package ru.itcube46.rest.repositories;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ru.itcube46.rest.entities.Questions;
public interface QuestionsRepository extends CrudRepository<Questions, Long> { 
   @Query("SELECT (SUM(QUESTION_SCORES))*2 FROM QUIZZES WHERE QUESTION_SCORES = :question_scores")
    Iterable<Questions> doubleSumQuestionsScores(@Param("question_scores") String question_scores);
   

}
