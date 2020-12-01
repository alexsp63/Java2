package com.popovas.popovas.controllers;

import com.popovas.popovas.exceptions.ResourceNotFoundException;
import com.popovas.popovas.model.Question;
import com.popovas.popovas.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public Page<Question> getQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @PostMapping("/questions/{questionId}")
    public Question createQuestion(@Valid @RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PutMapping("/questions/{questionId}")
    public Question updateQuestion(@PathVariable Long questionId, @Valid @RequestBody Question questionRequest) {
        return questionRepository.findById(questionId).map(question -> {
            question.setTitle(questionRequest.getTitle());
            question.setDescription(questionRequest.getDescription());
            return questionRepository.save(question);
        }).orElseThrow(() -> new ResourceNotFoundException("QuestionId " + questionId + " not found"));
    }

    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
        return questionRepository.findById(questionId).map(question -> {
            questionRepository.delete(question);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("QuestionId " + questionId + " not found"));
    }

}
