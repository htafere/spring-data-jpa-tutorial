package com.bakaroo.spring.data.jpa.tutorial.repo;

import static org.junit.jupiter.api.Assertions.*;

import com.bakaroo.spring.data.jpa.tutorial.entity.Course;
import com.bakaroo.spring.data.jpa.tutorial.entity.Teacher;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepoTest {

  @Autowired
  private TeacherRepo teacherRepo;

  @Test
  public void saveTeacher() {
    Course courseDba = Course.builder()
        .title("DBA")
        .credit(5)
        .build();

    Course courseJava = Course.builder()
        .title("Java")
        .credit(10)
        .build();

    Teacher teacher = Teacher.builder()
        .firstName("Haftu")
        .lastName("Tafere")
        //.courses(List.of(courseDba, courseJava))
        .build();

    teacherRepo.save(teacher);
  }

}