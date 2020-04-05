package exercise.snowmobiletestresultdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import exercise.snowmobiletestresultdb.domain.TestReport;
import exercise.snowmobiletestresultdb.domain.TestReportRepository;
import exercise.snowmobiletestresultdb.domain.User;
import exercise.snowmobiletestresultdb.domain.UserRepository;

@SpringBootApplication
public class SnowmobileTestresultDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnowmobileTestresultDbApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner CLR(
			TestReportRepository trRepo,
			UserRepository userRepo) {
		
		return (args) -> {
			
			// Reports
			TestReport tr1 = new TestReport(
					"Lupus", "Test", "Today", "Someone", "VIEW BUTTON");
			TestReport tr2 = new TestReport(
					"Sciurus", "Test", "Today", "Someone", "VIEW BUTTON");
			TestReport tr3 = new TestReport(
					"Mephitis", "Test", "Today", "Someone", "VIEW BUTTON");
			trRepo.save(tr1);
			trRepo.save(tr2);
			trRepo.save(tr3);
			
			// Users
			User u1 = new User("admin", "ADMIN",
					"etu","suku","addr","phone","email",
					"$2b$12$oDcqQft.Zz9IjNEbY5Hso.HAjcVB/dWfWfDD8IxDDGMSJ2lnPcZMK");
			User u2 = new User("tester", "TESTER",
					"etu","suku","addr","phone","email",
					"$2b$12$EftI0F11VetixKl96cDRRuh3rVHdyyVBNUNQ0TZHK.OKdyZbyOeP.");
			User u3 = new User("viewer", "VIEWER",
					"etu","suku","addr","phone","email",
					"$2b$12$EftI0F11VetixKl96cDRRuh3rVHdyyVBNUNQ0TZHK.OKdyZbyOeP.");
			userRepo.save(u1);			
			userRepo.save(u2);
			userRepo.save(u3);
		};
	}
}
