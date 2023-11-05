package admin_user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin_user.dto.CourseDto;
import admin_user.dto.UserDto;
import admin_user.model.AdminCourses;
import admin_user.model.Course;
import admin_user.model.User;
import admin_user.service.AdminCoursesService;
import admin_user.service.CourseService;
import admin_user.service.CourseServiceImpl;
import admin_user.service.UserService;
import admin_user.service.UserServiceImpl;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	@Autowired
	private CourseService courseService;
	
	
	@Autowired
	private CourseServiceImpl csi;
	
	@Autowired
	AdminCoursesService  admincourseserices; 
	
	@GetMapping("/")
	public String HomePage(@ModelAttribute("user") UserDto userDto) {
		return "home";
	}
	
	
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registered Successfuly!");
		return "login";
	}
	
	
	@PostMapping("/addcourse")
	public String saveCourse(@ModelAttribute("course") CourseDto courseDto, Model model) {
		courseService.save(courseDto);
		model.addAttribute("message", "course added Successfuly!");
		return "addcourse";
	}


	
	
	
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/addcourse")
	public String addcourse() {
		return "addcourse";
	}
	
	@GetMapping("/addstudent")
	public String addstudent() {
		return "addstudent";
	}
	
	@GetMapping("/feedback")
	public String feedback() {
		return "feedback";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/admincourses")
	public String admincourses() {
		return "admincourses";
	}
	
	
	@GetMapping("user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		
		List<Course> data = csi.getAllData();
        model.addAttribute("data", data);
        
		return "user";
	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin";
	}
	
	@GetMapping("userdata")
    public String viewData(Model model) {
        List<User> data = userServiceImpl.getAllData();
        model.addAttribute("data", data);
        return "userdata";
    }
	
	
	
	 @GetMapping("/displayofcourses")
	    public String displayCourses(Model model) {
	        List<AdminCourses> courses = admincourseserices.getAllCourses(); // Modify this method in CourseService
	        model.addAttribute("courses", courses);
	        return "displayofcourses"; // Return the name of the HTML template without the extension
	    }

	 
	 
    @PostMapping("/data/delete/{id}")
    public ResponseEntity<String> deleteData(@RequestParam Long id) {
        try {
            userServiceImpl.deleteData(id);
            return ResponseEntity.ok("Data deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting data");
        }
    }
    
    
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute AdminCourses course) {
        AdminCourses savedCourse = admincourseserices.saveCourse(course);
        if (savedCourse != null) {
            // Data saved successfully
            return "admincourses"; // Redirect to a success page or wherever you want
        } else {
            // Handle the case where saving the data failed
            return "errorPage"; // Redirect to an error page or handle the error appropriately
        }
    }
	
    
	
    
    
	
	

}
