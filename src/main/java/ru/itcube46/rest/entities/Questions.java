package ru.itcube46.rest.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("QUESTIONS")
public class Questions {
    @Id
    private Long id;
    
    private Long quizId;

    private String question;

    private String variant1;

    private String variant2;

    private String variant3;

    private String answer;
    
    private int questionScores;

    private Long questionNumber;
}
