package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.dto.CourseDto;
import admin_user.model.Course;
import admin_user.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements  CourseService{
	
	@Autowired
	public CourseRepository cr;

	@Override
	public Course save(CourseDto courseDto) {
		// TODO Auto-generated method stub
		Course c=new Course(courseDto.getCoursename(),courseDto.getCoursecode(),courseDto.getFaculty());
		return cr.save(c);
	}
	
	public List<Course> getAllData() {
        return cr.findAll();
    }

}
