package admin_user.dto;

public class CourseDto {
	String coursename;
	String coursecode;
	String faculty;
	
	public CourseDto(String coursename, String coursecode, String faculty) {
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
