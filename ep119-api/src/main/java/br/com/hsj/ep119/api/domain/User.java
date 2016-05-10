package br.com.hsj.ep119.api.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	private Integer id;
	
	private String name;
	
	private String email;
	
	private String workPhone;
	
	private String homePhone;
	
	private String mobilePhone;
	
	private Integer registrationNumber;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM")
	private Date birthday;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date iniciation;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date transition;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date elevation;
	
	public User() {
		super();
	}
	
	public User(Integer id, String name, String email, String workPhone, String homePhone, String mobilePhone,
			Integer registrationNumber, Date birthday, Date iniciation, Date transition, Date elevation) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.workPhone = workPhone;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.registrationNumber = registrationNumber;
		this.birthday = birthday;
		this.iniciation = iniciation;
		this.transition = transition;
		this.elevation = elevation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public Integer getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(Integer registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getIniciation() {
		return iniciation;
	}

	public void setIniciation(Date iniciation) {
		this.iniciation = iniciation;
	}

	public Date getTransition() {
		return transition;
	}

	public void setTransition(Date transition) {
		this.transition = transition;
	}

	public Date getElevation() {
		return elevation;
	}

	public void setElevation(Date elevation) {
		this.elevation = elevation;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
