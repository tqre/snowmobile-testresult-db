package exercise.snowmobiletestresultdb.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestReport {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String vehicle; // TODO: vehicle class
	private String testtype;
	private String time; // object?
	private String person; // TODO: person class
	private String report;
	
	public TestReport () {}
	
	public TestReport(String vehicle, String testtype, String time, String person, String report) {
		this.id = null;
		this.vehicle = vehicle;
		this.testtype = testtype;
		this.time = time;
		this.person = person;
		this.report = report;
	}
	
	public TestReport(Long id, String vehicle, String testtype, String time, String person, String report) {
		super();
		this.id = id;
		this.vehicle = vehicle;
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

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
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
		return "TestReport [id=" + id + ", vehicle=" + vehicle + ", testtype=" + testtype + ", time=" + time
				+ ", person=" + person + ", report=" + report + "]";
	}


}
