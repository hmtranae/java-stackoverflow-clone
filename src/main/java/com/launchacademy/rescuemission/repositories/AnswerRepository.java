package com.launchacademy.rescuemission.repositories;

import com.launchacademy.rescuemission.models.Answer;
import com.launchacademy.rescuemission.models.Question;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Integer> {
  List<Answer> findAllByQuestion(Question question);
}
