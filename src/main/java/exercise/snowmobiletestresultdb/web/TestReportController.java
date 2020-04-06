package exercise.snowmobiletestresultdb.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.snowmobiletestresultdb.domain.SnowMobileRepository;
import exercise.snowmobiletestresultdb.domain.TestReport;
import exercise.snowmobiletestresultdb.domain.TestReportRepository;

@Controller
public class TestReportController {

	@Autowired
	private TestReportRepository trRepo;
	
	@Autowired
	private SnowMobileRepository smRepo;
	
	@RequestMapping("/all_testreports")
	public String showAllTestReports(Model model) {
		model.addAttribute("get_all", trRepo.findAll());
		return "all_testreports";
	}
	// TODO: Method security - TESTER+ADMIN allowed
	@RequestMapping("/add_testreport")
	public String addTestReport(Model model) {
		model.addAttribute("testreport", new TestReport());
		model.addAttribute("all_snowmobiles", smRepo.findAll());
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
