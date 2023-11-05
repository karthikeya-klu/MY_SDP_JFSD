package admin_user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdminCourses {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String courseName;
	    private String facultyName;
	    private String courseCode;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public String getFacultyName() {
			return facultyName;
		}
		public void setFacultyName(String facultyName) {
			this.facultyName = facultyName;
		}
		public String getCourseCode() {
			return courseCode;
		}
		public void setCourseCode(String courseCode) {
			this.courseCode = courseCode;
		}

	    // Getters and setters
	    
	


}
