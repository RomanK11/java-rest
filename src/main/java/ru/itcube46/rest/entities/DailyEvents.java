package ru.itcube46.rest.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("DAILY_EVENTS")
public class DailyEvents {
    @Id
    private Long id;

    private Long quizId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;

    private String eventName;

    private String difficulty;

    public Integer dailyScores;
}