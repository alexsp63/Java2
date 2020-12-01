package com.popovas.popovas.controllers;

import com.popovas.popovas.exceptions.ResourceNotFoundException;
import com.popovas.popovas.model.Answer;
import com.popovas.popovas.model.Question;
import com.popovas.popovas.repository.AnswerRepository;
import com.popovas.popovas.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions/{questionId}/answers")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionID) {
        return answerRepository.findByQuestionId(questionID);
    }

    @PostMapping("/questions/{questionId}/answers")
    public Answer createAnswer(@PathVariable Long questionId,
                                 @Valid @RequestBody Answer answer) {
        return questionRepository.findById(questionId).map(question -> {
            answer.setQuestion(question);
            return answerRepository.save(answer);
        }).orElseThrow(() -> new ResourceNotFoundException("QuestionId " + questionId + " not found"));
    }

    @PutMapping("/questions/{questionId}/answers/{answerId}")
    public Answer updateAnswer(@PathVariable Long questionId,
                               @PathVariable Long answerId,
                               @Valid @RequestBody Answer answerRequest) {
        if (!questionRepository.existsById(questionId)){
            throw new ResourceNotFoundException("QuestionId " + questionId + " not found");
        }
        return answerRepository.findById(answerId).map(answer -> {
            answer.setText(answerRequest.getText());
            return answerRepository.save(answer);
        }).orElseThrow(() -> new ResourceNotFoundException("QuestionId " + questionId + " not found"));
    }

    @DeleteMapping("/questions/{questionId}/answers/{answerId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId,
                               @PathVariable Long answerId) {
        if (!questionRepository.existsById(questionId)){
            throw new ResourceNotFoundException("QuestionId " + questionId + " not found");
        }
        return answerRepository.findById(answerId).map(answer -> {
            answerRepository.delete(answer);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("QuestionId " + questionId + " not found"));
    }

}
