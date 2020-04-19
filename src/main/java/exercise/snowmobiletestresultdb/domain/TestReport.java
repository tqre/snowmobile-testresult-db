package exercise.snowmobiletestresultdb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class TestReport {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "snowmobileid") // Where did this come from??
	private SnowMobile snowmobile;
	
	@Pattern(regexp="^Smoke test|^Durability test|^Consumption test|^Safety test|^EMP test",
			 message="{error.test}")
	private String testtype;
	
	// This could be Date/DateTime object (whatever it is in Java)
	// combined from regexlib.com
	// matches YYYY-MM-DD hh:mm (checks for leap years too!)
	@Pattern(regexp="^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30))))) (([1-9]{1})|([0-1][0-9])|([1-2][0-3])):([0-5][0-9])$",
			 message = "{error.time}")
	private String time;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User person;
	
	@Column(length=1024)
	@Size(min=40, message="{error.too_short}")
	private String report;
	
	public TestReport () {}
	
	public TestReport(SnowMobile snowmobile, String testtype, String time, User person, String report) {
		this.snowmobile = snowmobile;
		this.testtype = testtype;
		this.time = time;
		this.person = person;
		this.report = report;
	}
	
	public TestReport(Long id, SnowMobile snowmobile, String testtype, String time, User person, String report) {
		this.id = id;
		this.snowmobile = snowmobile;
		this.testtype = testtype;
		this.time = time;
		this.person = person;
		this.report = report;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SnowMobile getSnowMobile() {
		return snowmobile;
	}

	public void setSnowMobile(SnowMobile snowmobile) {
		this.snowmobile = snowmobile;
	}

	public String getTesttype() {
		return testtype;
	}

	public void setTesttype(String testtype) {
		this.testtype = testtype;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getPerson() {
		return person;
	}

	public void setPerson(User person) {
		this.person = person;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "TestReport [id=" + id + ", vehicle=" + snowmobile + ", testtype=" + testtype + ", time=" + time
				+ ", person=" + person + ", report=" + report + "]";
	}


}
