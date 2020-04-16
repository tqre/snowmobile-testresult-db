package exercise.snowmobiletestresultdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.snowmobiletestresultdb.domain.SnowMobileRepository;
import exercise.snowmobiletestresultdb.domain.TestReport;
import exercise.snowmobiletestresultdb.domain.TestReportRepository;
import exercise.snowmobiletestresultdb.domain.User;
import exercise.snowmobiletestresultdb.domain.UserRepository;

@Controller
public class TestReportController {

	@Autowired
	private TestReportRepository trRepo;
	
	@Autowired
	private SnowMobileRepository smRepo;
	
	@Autowired
	private UserRepository uRepo;
	
	@RequestMapping("/all_testreports")
	public String showAllTestReports(Model model) {
		model.addAttribute("get_all", trRepo.findAll());
		return "all_testreports";
	}
	// TODO: Method security - TESTER+ADMIN allowed
	// TODO: Get logged user name from uRepo
	@RequestMapping("/add_testreport")
	public String addTestReport(Model model, 
			@AuthenticationPrincipal UserDetails currentUser) {
		model.addAttribute("testreport", new TestReport());
		model.addAttribute("all_snowmobiles", smRepo.findAll());
		
		// Secure? Probably not...
		User user = uRepo.findByUsername(currentUser.getUsername());
		model.addAttribute("firstName", user.getFirstname());
		model.addAttribute("lastName", user.getLastname());
		
		return "add_testreport";
	}	
	@RequestMapping("/save_testreport")
	public String saveTestReport(TestReport testreport) {
		trRepo.save(testreport);
		// TODO: notify user for success would be nice
		return "redirect:all_testreports";
	}
	@RequestMapping("/viewreport/{id}")
	public String getOneReport (
			@PathVariable("id") Long testReportId, Model model) {
		Optional<TestReport> testreport = trRepo.findById(testReportId);
		// We have to unwrap the Optional type to get our hands on to the object itself
		model.addAttribute("testreport", testreport.get());
		return "/viewreport";
	}
}
