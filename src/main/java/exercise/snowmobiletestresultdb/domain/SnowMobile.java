package exercise.snowmobiletestresultdb.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



@Entity
public class SnowMobile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Model name is needed")
	private String model;
	
	@Min(value = 1920, message = "Snowmobiles were not invented before 1920")
	@Max(value = 2025, message = "We are not planning THAT much ahead")
	private int year;
	
	@Min(value = 400, message = "has to be 400-6500 millimeters")
	@Max(value = 650, message = "has to be 400-6500 millimeters")
	private int trackWidth;
	
	@Min(value = 2500, message = "has to be 2500-4000 millimeters")
	@Max(value = 4000, message = "has to be 2000-4000 millimeters")	
	private int trackLength;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="snowmobile")
	private List<TestReport> tests;
		
	public SnowMobile() {}

	public SnowMobile(String model, int year, int trackWidth, int trackLength) {
		this.model = model;
		this.year = year;
		this.trackWidth = trackWidth;
		this.trackLength = trackLength;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTrackWidth() {
		return trackWidth;
	}

	public void setTrackWidth(int trackWidth) {
		this.trackWidth = trackWidth;
	}

	public int getTrackLength() {
		return trackLength;
	}

	public void setTrackLength(int trackLength) {
		this.trackLength = trackLength;
	}

	public List<TestReport> getTests() {
		/*
		if (this.tests.get(0).equals(null)) {
			List<TestReport> notests = new ArrayList<TestReport>();
			notests.add(new TestReport());
			return notests;
		}
		*/
		return tests;
	}

	public void setTests(List<TestReport> tests) {
		this.tests = tests;
	}	
}
