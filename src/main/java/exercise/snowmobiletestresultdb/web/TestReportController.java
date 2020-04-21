package exercise.snowmobiletestresultdb.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/add_testreport")
	public String addTestReport(Model model, 
			@AuthenticationPrincipal UserDetails currentUser) {
		
		model.addAttribute("testReport", new TestReport());
		model.addAttribute("all_snowmobiles", smRepo.findAll());
		
		User tester = uRepo.findByUsername(currentUser.getUsername());
		model.addAttribute("firstname", tester.getFirstname());
		model.addAttribute("lastname", tester.getLastname());
		return "add_testreport";
	}
	
	// Validation works, but instead of message, a whitelabel error page appears!
	// The method arguments have to be in right order!! BindingResult
	// has to come imediately after @Valid attribute.
	@PostMapping("/save_testreport")
	public String saveTestReport(Model model, 
			@AuthenticationPrincipal UserDetails currentUser,
			@Valid TestReport testReport,
			BindingResult bindingResult) {
	
		User tester = uRepo.findByUsername(currentUser.getUsername());
		model.addAttribute("firstname", tester.getFirstname());
		model.addAttribute("lastname", tester.getLastname());
		model.addAttribute("all_snowmobiles", smRepo.findAll());
		
		if (bindingResult.hasErrors()) {
			return "add_testreport";
		}
		
		testReport.setPerson(tester);
		trRepo.save(testReport);
		// TODO: notify user for success would be nice
		return "redirect:all_testreports";
	}
	
	@RequestMapping("/viewreport/{id}")
	public String getOneReport (Model model,
			@PathVariable("id") Long testReportId) {
		
		Optional<TestReport> testreport = trRepo.findById(testReportId);
		// We have to unwrap the Optional type to get our hands on to the object itself
		model.addAttribute("testreport", testreport.get());
		return "/viewreport";
	}
	
	@RequestMapping("/delete_testreport/{id}")
	public String deleteTestReport(Model model,
			@PathVariable("id") Long testReportId) {
		
		trRepo.deleteById(testReportId);
		return "redirect:../all_testreports";
	}
	
	// TODO: method level security
	@RequestMapping("/edit_testreport/{id}")
	public String edit_TestReport(Model model,
			@AuthenticationPrincipal UserDetails currentUser,
			@PathVariable("id") Long testReportId) {
		
		Optional<TestReport> testReport = trRepo.findById(testReportId);
		model.addAttribute("testReport", testReport.get());		
		
		User tester = uRepo.findByUsername(currentUser.getUsername());
		model.addAttribute("firstname", tester.getFirstname());
		model.addAttribute("lastname", tester.getLastname());
		
		return "edit_testreport";
	}
	
	@RequestMapping("/save_edited_testreport")
	public String checkSnowMobileEdit(Model model,
			@AuthenticationPrincipal UserDetails currentUser,
			@Valid TestReport testReport,
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "edit_testreport";
		}
		
		Optional<TestReport> oldreport = trRepo.findById(testReport.getId());
		TestReport oldreport_unwrapped = oldreport.get();
		
		// Editing user can be saved from this variable
		// User user = uRepo.findByUsername(currentUser.getUsername());
		// This keeps the original report maker
		testReport.setPerson(oldreport_unwrapped.getPerson()); 
		testReport.setTime(oldreport_unwrapped.getTime());
		testReport.setSnowMobile(oldreport_unwrapped.getSnowMobile());
		
		trRepo.save(testReport);
		// TODO: notify user for success would be nice
		return "redirect:all_testreports";
	}
}
