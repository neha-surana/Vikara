package business.user;

import java.io.Serializable;

public class User implements Serializable {

	/*
	 * TODO: Create private fields corresponding to the fields in the
	 * book table of your database. Generate a constructor that
	 * uses those fields. Generate getter methods for those fields,
	 * and generate a toString method that uses those fields.
	 */
	private long user_id;
	private String username;
	private String email;
	private String password;

	private String confirm_password;
	private String address;
	private String country;
	private String state;
	private String zipcode;

	public User(){}

	public User(long user_id, String username, String email, String password, String confirm_password, String address, String country, String state, String zipcode) {
		this.user_id = user_id;
		this.email=email;
		this.username = username;
		this.password = password;
		this.confirm_password = confirm_password;
		this.address = address;
		this.country = country;
		this.state = state;
		this.zipcode = zipcode;
	}

	public long getUserId() {
		return user_id;
	}

	public void setUserId(long userId) {
		this.user_id = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "User{" +
				"userId=" + user_id +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", confirm_password='" + confirm_password + '\'' +
				", address='" + address + '\'' +
				", country='" + country + '\'' +
				", state='" + state + '\'' +
				", zipcode='" + zipcode + '\'' +
				'}';
	}
}
