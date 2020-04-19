package exercise.snowmobiletestresultdb.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		model.addAttribute("user", new User());
		return "add_user";
	}
	
	@RequestMapping("/save_user")
	public String saveNewUser(Model model,
			@Valid User user,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "add_user";
		}		
		
		BCryptPasswordEncoder hasher = new BCryptPasswordEncoder();
		String hashedUserInput = hasher.encode(user.getPwdHash());
		user.setPwdHash(hashedUserInput);
		uRepo.save(user);
		// TODO: notify user for success would be really nice
		return "redirect:all_users";
	}
	
	@RequestMapping("/edit_user")
	public String editUser(Model model,
			@AuthenticationPrincipal UserDetails currentUser) {
		User user = uRepo.findByUsername(currentUser.getUsername());
		model.addAttribute("user", user);
		return "myaccount";
	}	

	@RequestMapping("/modify_user")
	public String modifyUser(Model model,
			@AuthenticationPrincipal UserDetails currentUser,
			@Valid User user,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "myaccount";
		}
		
		User olduserdata = uRepo.findByUsername(currentUser.getUsername());
		// We definetely don't want to show this data in clientside, so
		// get it just before saving the new data.
		user.setId(olduserdata.getId());
		user.setUsername(olduserdata.getUsername());
		user.setPwdHash(olduserdata.getPwdHash());
		user.setRole(olduserdata.getRole());		
		uRepo.save(user);
		// TODO: confirmation message
		// TODO: review data ???
		return "index";
	}

}
