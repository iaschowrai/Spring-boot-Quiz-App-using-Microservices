package com.quizapp.questionservice.service;


import com.quizapp.questionservice.dao.QuestionDao;
import com.quizapp.questionservice.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> getQuestionById(Integer id) {
        try {
            // Retrieve the question from the database
            Question question = questionDao.findQuestionById(id);

            // Check if the question exists
            if (question != null) {
                // Return the question with HTTP status OK
                return new ResponseEntity<>(question, HttpStatus.OK);
            } else {
                // Return an empty response with HTTP status NOT FOUND
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the exception (You might want to use a logger here)
            e.printStackTrace();

            // Return an empty response with HTTP status BAD REQUEST
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public ResponseEntity<String> addQuestions(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public String updateQuestion(Integer id, Question question){
        questionDao.save(questionDao.findQuestionById(id));
        return "updated";
    }
    public String deleteQuestion( Integer id){
       questionDao.deleteById(id);
        return "Deleted";
    }
}
