package exercise.snowmobiletestresultdb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

	@RequestMapping("/index")
	public String firstEndpoint() {
		return "index";
	}
}
