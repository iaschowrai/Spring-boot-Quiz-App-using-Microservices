package com.quizapp.questionservice.controller;


import com.quizapp.questionservice.model.Question;
import com.quizapp.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestions(question);
    }

    @PutMapping("update/{id}")
    public String updateQuestion(@RequestBody Integer id, Question question){
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }
}