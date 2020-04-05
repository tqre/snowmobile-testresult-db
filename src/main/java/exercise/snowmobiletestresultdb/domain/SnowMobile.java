package exercise.snowmobiletestresultdb.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SnowMobile {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String model;
	private int year;
	private int trackWidth;
	private int trackLength;
	private ArrayList<String> tests; // TODO: <List> entity

	public SnowMobile() {}

	public SnowMobile(String model, int year, int trackWidth, int trackLength) {
		this.model = model;
		this.year = year;
		this.trackWidth = trackWidth;
		this.trackLength = trackLength;
		this.tests = new ArrayList<String>();
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

	// List getter?
	public ArrayList<String> getTests() {
		return tests;
	}

	// This setter probably fails
	public void setTests(ArrayList<String> tests) {
		this.tests = tests;
	}
	
	
}
