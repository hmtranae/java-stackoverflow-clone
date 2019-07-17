package com.launchacademy.rescuemission.controllers;

import com.launchacademy.rescuemission.models.Answer;
import com.launchacademy.rescuemission.models.Question;
import com.launchacademy.rescuemission.repositories.AnswerRepository;
import com.launchacademy.rescuemission.repositories.QuestionRepository;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class QuestionController {

  private final QuestionRepository questionRepository;
  private final AnswerRepository answerRepository;

  @Autowired
  public QuestionController(
      QuestionRepository questionRepository, AnswerRepository answerRepository) {
    this.questionRepository = questionRepository;
    this.answerRepository = answerRepository;
  }

  @GetMapping("/questions/new")
  public String newQuestionForm(@ModelAttribute Question question, Model model) {
    model.addAttribute("question", question);
    return "questions/new";
  }

  @PostMapping("/questions")
  public String postNewQuestion(
      @ModelAttribute @Valid Question question,
      BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      return "questions/new";
    }
    questionRepository.save(question);
    return "redirect:/questions/index";
  }

  @GetMapping("/questions/index")
  public String getAllQuestions(Model model) {
    model.addAttribute("questions", questionRepository.findAll(Sort.by(Direction.DESC,
        "createdOn")));
    return "questions/index";
  }

  @GetMapping("/questions/show/{questionId}")
  public String getQuestion(@PathVariable Integer questionId, @ModelAttribute Answer answer,
      Model model) {
    questionRepository.findById(questionId)
        .ifPresent(question -> model.addAttribute("question", question));
    model.addAttribute("answer", answer);
    return "questions/show";
  }

  @PostMapping("/questions/{questionId}/answers")
  public String postNewAnswer(
      @ModelAttribute @Valid Answer answer,
      BindingResult bindingResult,
      Model model,
      @PathVariable Integer questionId) {
    if (bindingResult.hasErrors()) {
      return "questions/show";
    }
    Question question = questionRepository.findById(questionId).orElse(null);
    answer.setQuestion(question);
    answerRepository.save(answer);
    return "redirect:/questions/show/{questionId}";
  }
}
