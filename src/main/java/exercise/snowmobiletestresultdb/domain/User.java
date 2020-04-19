package exercise.snowmobiletestresultdb.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@Size(min=3, message = "{error.username}")
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	// Make a class out of this so users can have multiple roles?
	// TODO: define roles!
	@Column(name = "role", nullable = false)
	private String role;
	
	@Size(min=1, message = "{error.namesize}")
	@Pattern(regexp = "[-a-zåäöA-ZÅÄÖ ]*",
			 message = "{error.nameletters}")
	private String firstname;
	
	@Size(min=1, message= "{error.namesize}")
	@Pattern(regexp = "[-a-zåäöA-ZÅÄÖ ]*",
			 message = "{error.nameletters}")
	private String lastname;
	
	@Size(min=1, message = "{error.address}")
	private String address;

	@Pattern(regexp = "[-0-9+ ]*",
			 message = "{error.telephone}")
	private String telephone;
	
	@Email(message = "{error.email}")
	private String email;
	
	@Column(name = "password", nullable = false)
	private String pwdHash;
	
	@OneToMany
	private List<TestReport> tests;
	
	public User() {}
	
	public User(String userName, String role, String firstName, String lastName, String address, String telephone,
			String email, String pwdHash) {

		this.username = userName;
		this.role = role;
		this.firstname = firstName;
		this.lastname = lastName;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.pwdHash = pwdHash;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwdHash() {
		return pwdHash;
	}

	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}

	public List<TestReport> getTests() {
		return tests;
	}
	
	public void setTests(List<TestReport> tests) {
		this.tests = tests;
	}
}
