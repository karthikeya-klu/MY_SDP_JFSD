package admin_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import admin_user.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	

}
