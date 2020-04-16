package exercise.snowmobiletestresultdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.snowmobiletestresultdb.domain.User;
import exercise.snowmobiletestresultdb.domain.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository uRepo;
	
	@RequestMapping("/all_users")
	public String showAllUsers(Model model) {
		model.addAttribute("get_all", uRepo.findAll());
		return "all_users";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
		
	@RequestMapping(value="/logout")
	public String logout() {
		return "logout";
	}
	
	@RequestMapping("/add_user")
	public String addTestReport(Model model) {
		model.addAttribute("newuser", new User());
		return "add_user";
	}
	
	@RequestMapping("/save_user")
	public String saveNewUser(User newuser) {
		BCryptPasswordEncoder hasher = new BCryptPasswordEncoder();
		String hashedUserInput = hasher.encode(newuser.getPwdHash());
		newuser.setPwdHash(hashedUserInput);
		uRepo.save(newuser);
		// TODO: notify user for success would be really nice
		return "redirect:all_users";
	}
	
	@RequestMapping("/edit_user")
	public String editUser(@AuthenticationPrincipal UserDetails currentUser,
			Model model) {
		User user = uRepo.findByUsername(currentUser.getUsername());
		model.addAttribute("modifieduser", user);
		return "myaccount";
	}	

	@RequestMapping("/modify_user")
	public String modifyUser(@AuthenticationPrincipal UserDetails currentUser,
			User modifieduser) {
		User olduserdata = uRepo.findByUsername(currentUser.getUsername());
		// This is a workaround, we definetely don't want to show this data in clientside
		modifieduser.setId(olduserdata.getId());
		modifieduser.setUsername(olduserdata.getUsername());
		modifieduser.setPwdHash(olduserdata.getPwdHash());
		modifieduser.setRole(olduserdata.getRole());		
		uRepo.save(modifieduser);
		// TODO: confirmation message
		// TODO: review data ???
		return "index";
	}

}
