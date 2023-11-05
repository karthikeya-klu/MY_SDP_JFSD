package admin_user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import admin_user.model.AdminCourses;
import admin_user.repositories.AdminCoursesRepository;

@Service
public class AdminCoursesService {
	
	
	    @Autowired
	    private AdminCoursesRepository courseRepository;

	    public AdminCourses saveCourse(AdminCourses admincourses) {
	        return courseRepository.save(admincourses);
	    }
	    
	    public List<AdminCourses> getAllCourses() {
	        return courseRepository.findAll();
	    }
	


}
