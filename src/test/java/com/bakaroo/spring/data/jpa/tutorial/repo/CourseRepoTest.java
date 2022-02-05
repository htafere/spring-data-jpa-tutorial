package com.bakaroo.spring.data.jpa.tutorial.repo;

import com.bakaroo.spring.data.jpa.tutorial.entity.Course;
import com.bakaroo.spring.data.jpa.tutorial.entity.Student;
import com.bakaroo.spring.data.jpa.tutorial.entity.Teacher;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Slf4j
@SpringBootTest
class CourseRepoTest {

  @Autowired private CourseRepo courseRepo;

  @Test
  public void printCourses() {
    List<Course> courseList = courseRepo.findAll();
    log.info("List of Courses: {}", courseList);
  }

  @Test
  public void saveCourseWithTeacher() {
    Teacher teacher = Teacher.builder().firstName("Nigisti").lastName("Amare").build();

    Course course = Course.builder().title("Python").credit(6).teacher(teacher).build();

    courseRepo.save(course);
  }

  @Test
  public void findAllPaginationCourses() {
    PageRequest firstPageWith3Records = PageRequest.of(0, 3);
    PageRequest secondPageWith2Records = PageRequest.of(1, 2);

    List<Course> listOfFirst3Courses = courseRepo.findAll(secondPageWith2Records).getContent();
    long totalElements = courseRepo.findAll(secondPageWith2Records).getTotalElements();
    long totalPages = courseRepo.findAll(secondPageWith2Records).getTotalPages();

    log.info("Total Elements: {}, Total Pages: {}", totalElements, totalPages);
    log.info("LCourses: {}", listOfFirst3Courses);
  }

  @Test
  public void findAllSorting() {
    PageRequest sortByTitle = PageRequest.of(0, 4, Sort.by("title"));

    PageRequest sortByCreditDesc = PageRequest.of(0, 4, Sort.by("credit").descending());

    PageRequest sortByTitleAndCreditDesc =
        PageRequest.of(0, 4, Sort.by("title").descending().and(Sort.by("credit")));

    List<Course> courses = courseRepo.findAll(sortByCreditDesc).getContent();
    log.info("Courses: {}", courses);
  }

  @Test
  public void printFindByTitleContaining() {
    PageRequest firstPageTenRecords = PageRequest.of(0, 10);

    List<Course> courses = courseRepo.findByTitleContaining("D", firstPageTenRecords).getContent();
    log.info("Courses: {}", courses);
  }

  @Test
  public void saveCourseWithStudentAndTeacher() {

    Teacher teacher = Teacher.builder()
        .firstName("Brian")
        .lastName("White")
        .build();

    Student student = Student.builder()
        .firstName("Chris")
        .lastName("Vo")
        .emailId("vchris@att.com")
        .build();

    Course course = Course.builder()
        .title("AI")
        .credit(12)
        .teacher(teacher)
        .build();

    course.addStudents(student);
    courseRepo.save(course);
  }
}
