package com.launchacademy.rescuemission.models;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "questions")
public class Question {
  @Id
  @SequenceGenerator(name = "question_generator", sequenceName = "questions_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotBlank
  @NonNull
  @Size(min = 20, message = "Title has to be at least 20 characters")
  @Column(name = "title", nullable = false)
  private String title;

  @NotBlank
  @NonNull
  @Size(min = 50, message = "Description has to be at least 50 characters")
  @Column(name = "description", nullable = false)
  private String description;

  @Basic(optional = false)
  @Column(name = "created_at", insertable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdOn;
}
