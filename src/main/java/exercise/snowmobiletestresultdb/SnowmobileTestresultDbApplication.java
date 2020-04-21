package exercise.snowmobiletestresultdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

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
					"Admin","Strator","SysAdmin basement 1337","016-394595","sysadmin@company.com",
					"$2b$12$C9sNsGKLZSM5uNA2PVrL4u4AZU1vWd1N8qcx4ZakigxXqzPYi/38a");
			User u2 = new User("tester", "TESTER",
					"Ted","Tester","Testgatan 123","040000000","ted.tester@company.com",
					"$2b$12$HEv3JT2vKaiA23FHaLujDO/750ATeV6wD49YvHd67n9zEolO24nvq");
			User u3 = new User("bigboss", "VIEWER",
					"Fred","Foreman","Boss street number one","+8816 3-1337 8055","bigboss@company.com",
					"$2b$12$oZwaWtIJqdZMWjdYD8xi5eF9ovRj0J4dmcORa036TqoZbSIs/oJh.");
			User u4 = new User("builder", "BUILDER",
					"Bertha","Builder","Puistokatu 4","0909090909","bbuilder@company.com",
					"$2b$12$2rtfx4lMquh/4w8AJAl5MOIgqxp2AEDFybxJsKJs4kepnl2IvbEzi");
			userRepo.save(u1);			
			userRepo.save(u2);
			userRepo.save(u3);
			userRepo.save(u4);
		};
	}
	
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();
	     
	    messageSource.setBasename("classpath:messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
	    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	    bean.setValidationMessageSource(messageSource());
	    return bean;
	}
}
