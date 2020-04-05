package exercise.snowmobiletestresultdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TestReport {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "modelid") // Where did this come from??
	private SnowMobile snowmobile;
	
	private String testtype;
	private String time; // object?
	private String person; // TODO: user class implement here
	private String report;
	
	public TestReport () {
		this.testtype = "No tests";
	}
	
	public TestReport(SnowMobile snowmobile, String testtype, String time, String person, String report) {
		this.snowmobile = snowmobile;
		this.testtype = testtype;
		this.time = time;
		this.person = person;
		this.report = report;
	}
	
	public TestReport(Long id, SnowMobile snowmobile, String testtype, String time, String person, String report) {
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

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
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
