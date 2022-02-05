package com.bakaroo.spring.data.jpa.tutorial.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class CourseMaterial {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_sequence")
  @SequenceGenerator(
      name = "course_material_sequence",
      sequenceName = "course_material_sequence",
      allocationSize = 1)
  private Long courseMaterialId;

  private String url;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "course_id", referencedColumnName = "courseId")
  @Exclude
  private Course course;
}
