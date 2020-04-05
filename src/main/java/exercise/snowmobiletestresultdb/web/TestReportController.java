package exercise.snowmobiletestresultdb.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.snowmobiletestresultdb.domain.TestReport;
import exercise.snowmobiletestresultdb.domain.TestReportRepository;

@Controller
public class TestReportController {

	@Autowired
	private TestReportRepository trRepo;
	
	@RequestMapping("/all_testreports")
	public String showAllTestReports(Model model) {
		model.addAttribute("get_all", trRepo.findAll());
		return "all_testreports";
	}
	// TODO: Method security - TESTER+ADMIN allowed
	@RequestMapping("/add_testreport")
	public String addTestReport(Model model) {
		model.addAttribute("testreport", new TestReport());
		return "add_testreport";
	}	
	@RequestMapping("/save_testreport")
	public String saveTestReport(TestReport testreport) {
		trRepo.save(testreport);
		// TODO: notify user for success would be nice
		return "redirect:all_testreports";
	}
}
