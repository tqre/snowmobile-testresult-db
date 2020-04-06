package exercise.snowmobiletestresultdb.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class SnowMobile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String model;
	private int year;
	private int trackWidth;
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
