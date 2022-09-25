package com.anubhavtrainings.entities;

import java.beans.ConstructorProperties;

import lombok.Getter;
import lombok.Setter;

public class vendor {
	
	@Setter 
	@Getter
	private String id;
	@Setter 
	@Getter
	private String firstName;
	@Setter 
	@Getter
	private String lastName;
	@Setter 
	@Getter
	private String companyName;
	@Setter 
	@Getter
	private String website;
	@Setter 
	@Getter
	private String email;
	@Setter 
	@Getter
	private String vstatus;
	@Setter 
	@Getter
	private String gstNumber;
	public vendor(String id, String firstName, String lastName, String companyName, String website, String email,
			String vstatus, String gstNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		this.website = website;
		this.email = email;
		this.vstatus = vstatus;
		this.gstNumber = gstNumber;
	}
	public vendor() {
		
	}
	
	
	
}
