package admin_user.service;

import admin_user.dto.CourseDto;
import admin_user.model.Course;



public  interface CourseService {
	
	Course save (CourseDto courseDto);

	

}
