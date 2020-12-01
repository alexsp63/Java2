package com.popovas.popovas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer extends AuditModel{
    @Id
    @GeneratedValue(generator = "answer_generator")
    @SequenceGenerator(
            name="answer_generator",
            sequenceName = "Answer_sequence",
            initialValue = 1000
    )
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(columnDefinition = "text") //создание колонок с типом данных текст
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Question question;

    private Question getQuestion(){
        return question;
    }

    public void setQuestion(Question question){
        this.question = question;
    }
}
