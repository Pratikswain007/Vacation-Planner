package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

@Entity
public class User {
	@Id
	protected int id;
	
	protected String name;
	
	protected String location;
	
	protected String modeoftravel;
	
	protected int duration;
	
	protected String email;
	
	public User( String name, String location, String modeoftravel, int duration, String email) {
		super();
		this.name = name;
		this.location = location;
		this.modeoftravel = modeoftravel;
		this.duration = duration;
		this.email=email;
	
	}
	
	
	
	
	public User(int id, String name, String location, String modeoftravel, int duration, String email) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.modeoftravel = modeoftravel;
		this.duration = duration;
		this.email=email;
	}
	
	
	
	public User() {
		super();
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getModeoftravel() {
		return modeoftravel;
	}
	public void setModeoftravel(String modeoftravel) {
		this.modeoftravel = modeoftravel;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}




	@Override
	public java.lang.String toString() {
		return "User [id=" + id + ", name=" + name + ", location=" + location + ", modeoftravel=" + modeoftravel
				+ ", duration=" + duration + ", email=" + email + "]";
	}


	







	

}
