package entity;

public class Student {
	
	private String dni;
	private String name;
	private String firstSurname;
	private String secondSurname;
	private String phone;
	private String email;
	private String password;
	private String country;
	private String fullAdress;
	private String cycleName;
	
	public Student() {
		super();
	}

	public Student(String dni, String name, String firstSurname, String secondSurname, String phone, String email,
			String country, String fullAdress, String cycleName) {
		super();
		this.dni = dni;
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.phone = phone;
		this.email = email;
		this.country = country;
		this.fullAdress = fullAdress;
		this.cycleName = cycleName;
	}

	public Student(String dni, String name, String firstSurname, String secondSurname, String phone, String email,
			String password, String country, String fullAdress, String cycleName) {
		super();
		this.dni = dni;
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.country = country;
		this.fullAdress = fullAdress;
		this.cycleName = cycleName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFullAdress() {
		return fullAdress;
	}

	public void setFullAdress(String fullAdress) {
		this.fullAdress = fullAdress;
	}

	public String getCycleName() {
		return cycleName;
	}

	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}

	@Override
	public String toString() {
		return "Student [dni=" + dni + ", name=" + name + ", firstSurname=" + firstSurname + ", secondSurname="
				+ secondSurname + ", phone=" + phone + ", email=" + email + ", country=" + country + ", fullAdress="
				+ fullAdress + ", cycleName=" + cycleName + "]";
	}
}
