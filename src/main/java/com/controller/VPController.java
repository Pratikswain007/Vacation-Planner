package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.ImplementationDAO;
import com.model.User;
import com.service.UserService;
import com.service.ServiceImpl;

@Controller
public class VPController {
	@Autowired
	private ImplementationDAO implementationDAO;

	@GetMapping({ "/", "/home" })
	public String showHome() {
		return "HomePage";
	}

	@GetMapping("/add")
	public String insertUser(HttpServletRequest request) {
		return "vacationPlanner";
	}
	@GetMapping("/delete")
	public String deleteUser(HttpServletRequest request) {
		return "DeleteUser";
	}
		
	@GetMapping("/updateform")
	public String updateForm(HttpServletRequest request) {
		return "UpdateForm";
	}

	// Endpoint to create a new user
	@PostMapping("/save")
	public String insertUser(@ModelAttribute User user) throws SQLException {
		implementationDAO.insertUser(user);
		return "Thankyoupage"; // Redirects to the endpoint to retrieve all users after creating a user
	}
	
	

	// Endpoint to retrieve all users
	@GetMapping("/getAll")
	public String showAllUsers(@ModelAttribute User user, HttpServletRequest request) {
		List<User> userList = implementationDAO.showAllUsers();
		request.setAttribute("userlist", userList);
		return "ShowAll"; // Returns a view to display the list of users
	}

	// Endpoint to retrieve a specific user by ID
	@GetMapping("/GetInfo/{id}")
	public String SelectUser(@PathVariable int id, Model model) {
		User user = implementationDAO.selectUser(id);
		model.addAttribute("user", user);
		return "UpdateUser"; // Returns a view to display the details of a user
	}

	// Endpoint to update an existing user
	@GetMapping("/updatebyid")
	public String updateUser(@ModelAttribute User user, RedirectAttributes attrs) throws SQLException {
		//EmployeeService service=new EmployeeServiceImpl();
		int count=implementationDAO.updateUser(user);
		attrs.addFlashAttribute("updatecount", count);
		if(count>0) {
			attrs.addFlashAttribute("updated","Employee with ID: "+user.getId()+" is updated successfully.");
		}else {
			attrs.addFlashAttribute("notupdated","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
	}
	@GetMapping("/deletebyid")
	public String deleteUser(@ModelAttribute User user , HttpServletRequest request, RedirectAttributes attrs) throws SQLException {
		Integer id=null;
		int count=0;
		if(Objects.nonNull(request.getParameter("id"))) {
			id=Integer.parseInt(request.getParameter("id"));
		}	
		//EmployeeService service=new EmployeeServiceImpl();
		if(Objects.nonNull(id)) {
			count=implementationDAO.deleteUser(id);
			attrs.addFlashAttribute("deletecount", count);
		}
		if(count>0) {
			attrs.addFlashAttribute("deleted","Employee with ID: "+id+" is deleted successfully.");
		}else {
			attrs.addFlashAttribute("notdeleted","An error occurred. Please try again...");
		}
		return "redirect:/getAll";
		
	}
}
