package admin_user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
	String coursename;
	String coursecode;
	String faculty;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Course(){
		super();
	}
	
	 public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }

	
	
	public Course(String coursename, String coursecode, String faculty) {
		super();
		this.coursename = coursename;
		this.coursecode = coursecode;
		this.faculty = faculty;
	}
	
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

}
