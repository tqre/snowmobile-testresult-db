package exercise.snowmobiletestresultdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.snowmobiletestresultdb.domain.User;
import exercise.snowmobiletestresultdb.domain.UserRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
}
