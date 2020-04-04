package exercise.snowmobiletestresultdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
