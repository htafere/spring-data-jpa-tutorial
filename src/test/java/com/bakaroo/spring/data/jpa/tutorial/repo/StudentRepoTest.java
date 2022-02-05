package com.bakaroo.spring.data.jpa.tutorial.repo;

import com.bakaroo.spring.data.jpa.tutorial.entity.Guardian;
import com.bakaroo.spring.data.jpa.tutorial.entity.Student;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class StudentRepoTest {

  @Autowired private StudentRepo studentRepo;

  @Test
  public void saveStudent() {
    Student student =
        Student.builder()
            .emailId("u950055@gmail.com")
            .firstName("Haftu")
            .lastName("Tafere")
            // .guardianName("Guardian")
            // .guardianMobile("2147141051")
            // .guardianEmail("guardian@gmail.com")
            .build();

    studentRepo.save(student);
  }

  @Test
  public void printAllStudents() {
    List<Student> studentList = studentRepo.findAll();
    log.info("studentList = {}", studentList);
  }

  @Test
  public void saveStudentWithGuardian() {

    Guardian guardian =
        Guardian.builder()
            .name("Haftu Tafere")
            .email("u950055@gmail.com")
            .mobile("123456789")
            .build();

    Student student =
        Student.builder()
            .firstName("Nigisti")
            .lastName("Amare")
            .emailId("anigisti@gmail.com")
            .guardian(guardian)
            .build();

    studentRepo.save(student);
  }

  @Test
  public void printStudentByFirstName() {
    List<Student> studentList = studentRepo.findByFirstName("Haftu");
    log.info("studentList: {}", studentList);
  }

  @Test
  public void printStudentByFirstNameContaining() {
    List<Student> studentList = studentRepo.findByFirstNameContaining("Haf");
    log.info("studentList: {}", studentList);
  }

  @Test
  public void printStudentBasedOnGuardianName() {
    List<Student> studentList = studentRepo.findByGuardianName("Haftu Tafere");
    log.info("studentList: {}", studentList);
  }

  @Test
  public void printStudentByFirstNameAndLastName() {
    List<Student> studentList = studentRepo.findByFirstNameAndLastName("Nigisti", "Amare");
    log.info("studentList: {}", studentList);
  }

  @Test
  public void printStudentByEmailId() {
    Student student = studentRepo.getStudentByEmailAddress("u950055@gmail.com");
    log.info("student: {}", student);
  }

  @Test
  public void printFirstNameByEmailId() {
    String firstName = studentRepo.getFirstNameByEmailAddress("u950055@gmail.com");
    log.info("First Name: {}", firstName);
  }

  @Test
  public void printStudentByEmailIdNativeQuery() {
    Student student = studentRepo.getStudentByEmailAddressNative("u950055@gmail.com");
    log.info("Student: {}", student);
  }

  @Test
  public void printStudentByEmailIdNativeQueryNamedParam() {
    Student student = studentRepo.getStudentByEmailAddressNativeNamedParam("u950055@gmail.com");
    log.info("Student: {}", student);
  }

  @Test
  public void updateStudentNameByEmailId() {
    int returnVal = studentRepo.updateStudentNameByEmailId("Haf", "anigisti@gmail.com");
    log.info("Returned Value: {}", returnVal);
  }
}
