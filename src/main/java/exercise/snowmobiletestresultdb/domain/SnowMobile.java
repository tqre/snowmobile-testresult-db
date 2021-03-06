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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class SnowMobile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Pattern(regexp = "[-0-9a-zA-Z ]*",
			 message = "{error.fancy_characters}")
	@Size(min=5, max=30, message="{error.model}")
	private String model;
	
	@Min(value = 1920, message= "{error.too_old}")
	@Max(value = 2025, message= "{error.in_the_future}")
	private int year;
	
	@Min(value = 400, message="{error.track_width}")
	@Max(value = 650, message="{error.track_width}")
	private int trackWidth;

	@Min(value = 2500, message="{error.track_length}")
	@Max(value = 4000, message="{error.track_length}")	
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
		return tests;
	}

	public void setTests(List<TestReport> tests) {
		this.tests = tests;
	}	
}
