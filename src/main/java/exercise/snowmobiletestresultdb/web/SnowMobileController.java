package exercise.snowmobiletestresultdb.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="/add_snowmobile", method=RequestMethod.GET)
	public String addSnowMobile(Model model) {
		model.addAttribute("snowmobile", new SnowMobile());
		return "add_snowmobile";
	}
	
	@RequestMapping(value="/add_snowmobile", method=RequestMethod.POST)
	public String saveSnowMobile(@Valid SnowMobile snowmobile,
			BindingResult bindingResult, Model model) {
		model.addAttribute("snowmobile", snowmobile);
		if (bindingResult.hasErrors()) {
			return "add_snowmobile";
		}
		smRepo.save(snowmobile);
		// TODO: notify user for success would be nice
		return "redirect:all_snowmobiles";
	}
	
	@RequestMapping("/snowmobilestatus/{id}")
	public String getTestsForSnowMobileModel(
			@PathVariable("id") Long snowMobileId, Model model) {
		Optional<SnowMobile> snowmobile = smRepo.findById(snowMobileId);
		// We have to unwrap the Optional type to get our hands on to the object itself
		model.addAttribute("snowmobile", snowmobile.get());
		return "/viewtests";
	}
}
