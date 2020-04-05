package exercise.snowmobiletestresultdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.snowmobiletestresultdb.domain.SnowMobileRepository;

@Controller
public class SnowMobileController {

	@Autowired
	private SnowMobileRepository smRepo;
	
	@RequestMapping("/all_snowmobiles")
	public String showAllTestReports(Model model) {
		model.addAttribute("get_all", smRepo.findAll());
		return "all_snowmobiles";
	}
}
