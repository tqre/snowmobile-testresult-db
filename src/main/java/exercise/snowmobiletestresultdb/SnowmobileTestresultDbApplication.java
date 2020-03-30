package exercise.snowmobiletestresultdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import exercise.snowmobiletestresultdb.domain.TestReport;
import exercise.snowmobiletestresultdb.domain.TestReportRepository;

@SpringBootApplication
public class SnowmobileTestresultDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnowmobileTestresultDbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner CLR(
			TestReportRepository trRepo) {
		
		return (args) -> {
			
			// Constructor:
			TestReport tr1 = new TestReport(
					"Lupus", "Test", "Today", "Someone", "todo");
			TestReport tr2 = new TestReport(
					"Sciurus", "Test", "Today", "Someone", "todo");
			trRepo.save(tr1);
			trRepo.save(tr2);
		};
	}
}
