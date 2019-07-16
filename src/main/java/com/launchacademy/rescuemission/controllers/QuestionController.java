package com.launchacademy.rescuemission.controllers;

import com.launchacademy.rescuemission.models.Question;
import com.launchacademy.rescuemission.repositories.QuestionRepository;
import javax.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class QuestionController {

  private final QuestionRepository questionRepository;

  public QuestionController(
      QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
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
}
