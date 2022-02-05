package com.bakaroo.spring.data.jpa.tutorial.repo;

import static org.junit.jupiter.api.Assertions.*;

import com.bakaroo.spring.data.jpa.tutorial.entity.Course;
import com.bakaroo.spring.data.jpa.tutorial.entity.CourseMaterial;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CourseMaterialRepoTest {

  @Autowired
  private CourseMaterialRepo courseMaterialRepo;

  @Test
  public void saveCourseMaterial() {
    Course course = Course.builder()
        .title("DSA")
        .credit(6)
        .build();

    CourseMaterial courseMaterial = CourseMaterial.builder()
        .url("www.bakaroo.com")
        .course(course)
        .build();

    courseMaterialRepo.save(courseMaterial);

  }

  @Test
  public void printAllCourseMaterials() {
    List<CourseMaterial> courseMaterialList = courseMaterialRepo.findAll();
    log.info("Course Materials: {}", courseMaterialList);
  }
}