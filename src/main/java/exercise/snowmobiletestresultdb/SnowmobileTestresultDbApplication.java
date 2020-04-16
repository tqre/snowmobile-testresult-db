package exercise.snowmobiletestresultdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import exercise.snowmobiletestresultdb.domain.SnowMobile;
import exercise.snowmobiletestresultdb.domain.SnowMobileRepository;
//import exercise.snowmobiletestresultdb.domain.TestReport;
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
			SnowMobileRepository smRepo,
			TestReportRepository trRepo,
			UserRepository userRepo) {
		
		return (args) -> {
			
			// Snowmobiles
			
			SnowMobile sm1 = new SnowMobile("Lupus superx450", 1930, 450, 3500);
			SnowMobile sm2 = new SnowMobile("Sciurus furry99", 1999, 500, 3700);
			SnowMobile sm3 = new SnowMobile("Mephitis superExhaust 3900", 2020, 600, 3900);
			
			smRepo.save(sm1);
			smRepo.save(sm2);
			smRepo.save(sm3);
			
			/* Reports
			TestReport tr1 = new TestReport(
					"Lupus", "Test", "Today", "Someone", "VIEW BUTTON");
			TestReport tr2 = new TestReport(
					"Sciurus", "Test", "Today", "Someone", "VIEW BUTTON");
			TestReport tr3 = new TestReport(
					"Mephitis", "Test", "Today", "Someone", "VIEW BUTTON");
			trRepo.save(tr1);
			trRepo.save(tr2);
			trRepo.save(tr3);
			*/
			
			// Users
			User u1 = new User("admin", "ADMIN",
					"Admin","Strator","SysAdmin street 1337","016-394595","sysadmin@company.com",
					"$2b$12$oDcqQft.Zz9IjNEbY5Hso.HAjcVB/dWfWfDD8IxDDGMSJ2lnPcZMK");
			User u2 = new User("tester", "TESTER",
					"Ted","Tester","Testgatan 123","040000000","ted.tester@company.com",
					"$2b$12$EftI0F11VetixKl96cDRRuh3rVHdyyVBNUNQ0TZHK.OKdyZbyOeP.");
			User u3 = new User("bigboss", "VIEWER",
					"Fred","Foreman","Boss street 1","123123123","bigboss@company.com",
					"$2b$12$EftI0F11VetixKl96cDRRuh3rVHdyyVBNUNQ0TZHK.OKdyZbyOeP.");
			User u4 = new User("builder", "BUILDER",
					"Bertha","Builder","Puistokatu 4","4812","bbuilder@company.com",
					"$2b$12$EftI0F11VetixKl96cDRRuh3rVHdyyVBNUNQ0TZHK.OKdyZbyOeP.");
			userRepo.save(u1);			
			userRepo.save(u2);
			userRepo.save(u3);
			userRepo.save(u4);
		};
	}
}
