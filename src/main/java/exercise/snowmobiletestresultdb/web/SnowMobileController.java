package exercise.snowmobiletestresultdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.snowmobiletestresultdb.domain.SnowMobile;
import exercise.snowmobiletestresultdb.domain.SnowMobileRepository;
import exercise.snowmobiletestresultdb.domain.TestReportRepository;

@Controller
public class SnowMobileController {

	@Autowired
	private SnowMobileRepository smRepo;
	
	@Autowired
	private TestReportRepository trRepo;
	
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
	
	@RequestMapping("/snowmobilestatus/{id}")
	public String getTestsForSnowMobileModel(
			@PathVariable("id") Long snowMobileId, Model model) {
		Optional<SnowMobile> snowmobile = smRepo.findById(snowMobileId);
		model.addAttribute("snowmobile", snowmobile);
		// TODO: get all tests to model for now...
		//model.addAttribute("tests", trRepo.findAll());
		return "/viewtests";
	}
	/* REST methods??
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return bookRepository.findById(bookId);
	}
	*/
}
