package exercise.snowmobiletestresultdb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	// Make a class out of this so users can have multiple roles?
	// TODO: define roles!
	@Column(name = "role", nullable = false)
	private String role;
	
	private String firstname;
	private String lastname;
	private String address;
	private String telephone;
	private String email;
	
	@Column(name = "password", nullable = false)
	private String pwdHash;
	
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
}
