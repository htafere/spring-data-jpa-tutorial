package com.bakaroo.spring.data.jpa.tutorial.repo;

import com.bakaroo.spring.data.jpa.tutorial.entity.Student;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

  // Reference for the different query methods
  // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods

  public List<Student> findByFirstName(String firstName);

  public List<Student> findByFirstNameContaining(String name);

  public List<Student> findByLastNameNotNull();

  public List<Student> findByGuardianName(String guardianName);

  public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

  // JPQL
  @Query("Select s from Student s where s.emailId = ?1")
  public Student getStudentByEmailAddress(String emailId);

  // JPQL
  @Query("Select s.firstName from Student s where s.emailId = ?1")
  String getFirstNameByEmailAddress(String emailId);

  // Native Query
  @Query(value = "SELECT * FROM tbl_student s where s.email_address = ?1", nativeQuery = true)
  public Student getStudentByEmailAddressNative(String emailId);

  // Native Query: Named Parameter
  @Query(value = "SELECT * FROM tbl_student s where s.email_address = :emailId", nativeQuery = true)
  public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

  @Modifying
  @Transactional
  @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
  int updateStudentNameByEmailId(String firstName, String emailId);
}
