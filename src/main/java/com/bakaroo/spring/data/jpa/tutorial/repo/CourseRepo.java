package com.bakaroo.spring.data.jpa.tutorial.repo;

import com.bakaroo.spring.data.jpa.tutorial.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

  Page<Course> findByTitleContaining(String title, Pageable pageable);
}
