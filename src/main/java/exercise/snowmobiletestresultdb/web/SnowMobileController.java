package exercise.snowmobiletestresultdb.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/add_snowmobile")
	public String addSnowMobile(Model model) {
		model.addAttribute("snowMobile", new SnowMobile());
		return "add_snowmobile";
	}
	// REALLY: it has to read snowMobile!
	// Namespaces, consistency in naming, but not expecting this kind of stuff to happen
	// http://forum.thymeleaf.org/Fields-object-functions-Spring-td3302513.html
	@PostMapping("/save_snowmobile")
	public String checkSnowMobile(@Valid SnowMobile snowMobile,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "add_snowmobile";
		}
		smRepo.save(snowMobile);
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
	
	// TODO: method level security
	@RequestMapping("/edit_snowmobile/{id}")
	public String edit_SnowMobile(Model model,
			@PathVariable("id") Long snowMobileId) {
		
		Optional<SnowMobile> snowmobile = smRepo.findById(snowMobileId);		
		model.addAttribute("snowMobile", snowmobile.get());
		return "edit_snowmobile";
	}
	
	@RequestMapping("/save_edited_snowmobile")
	public String checkSnowMobileEdit(@Valid SnowMobile snowMobile,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "edit_snowmobile";
		}
		smRepo.save(snowMobile);
		// TODO: notify user for success would be nice
		return "redirect:all_snowmobiles";
	}
	
	// Idea: this function could just hide the vehicle from the view
	// and select lists, and keep everything in the database. Now
	// we are just brutally deleting it along with all tests.
	@RequestMapping("/decommission_snowmobile/{id}")
	public String decommissionSnowMobile(
			@PathVariable("id") Long snowMobileId) {
		
		smRepo.deleteById(snowMobileId);
		return "redirect:../all_snowmobiles";
	}
}
