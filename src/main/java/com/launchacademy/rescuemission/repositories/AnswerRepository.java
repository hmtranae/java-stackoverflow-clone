package com.launchacademy.rescuemission.repositories;

import com.launchacademy.rescuemission.models.Answer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Integer> {
}
