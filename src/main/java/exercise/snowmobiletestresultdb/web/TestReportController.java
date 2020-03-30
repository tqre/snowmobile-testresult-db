package exercise.snowmobiletestresultdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestReportController {

	@RequestMapping("/all_testreports")
	public String showAllTestReports(Model model) {
		return "all_testreports";
	}
}
