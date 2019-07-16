package com.launchacademy.rescuemission.repositories;

import com.launchacademy.rescuemission.models.Question;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends PagingAndSortingRepository<Question, Integer> {
}
