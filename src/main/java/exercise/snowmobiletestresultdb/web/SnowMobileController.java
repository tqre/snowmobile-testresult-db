package exercise.snowmobiletestresultdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.snowmobiletestresultdb.domain.SnowMobile;
import exercise.snowmobiletestresultdb.domain.SnowMobileRepository;

@Controller
public class SnowMobileController {

	@Autowired
	private SnowMobileRepository smRepo;
	
	@RequestMapping("/all_snowmobiles")
	public String showAllSnowMobiles(Model model) {
		model.addAttribute("get_all", smRepo.findAll());
		return "all_snowmobiles";
	}
	
	@RequestMapping("/add_snowmobile")
	public String addSnowMobile(Model model) {
		model.addAttribute("snowmobile", new SnowMobile());
		return "add_snowmobile";
	}
	
	@RequestMapping("/save_snowmobile")
	public String saveSnowMobile(SnowMobile snowmobile) {
		smRepo.save(snowmobile);
		// TODO: notify user for success would be nice
		return "redirect:all_snowmobiles";
	}
}
