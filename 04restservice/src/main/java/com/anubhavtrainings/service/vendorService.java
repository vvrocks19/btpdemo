package com.anubhavtrainings.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anubhavtrainings.entities.Vendor;

@Component
public class vendorService {
	
	//Internal Table
	HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();
	@Autowired
	Vendor x;
	@Autowired
	Vendor y;
	@Autowired
	Vendor z;
	
	public HashMap<String, Vendor> readAllVendors(){
		fillVendor();
		return vendors;
	}
	
	public Vendor getSingleVendorById(String vendorCode) {
		fillVendor();
		return (Vendor)vendors.get(vendorCode);
	}
	
	public Vendor changeVendor(Vendor vendor) {
		return vendor;
	}
	
	public Vendor createVendor(Vendor vendor) {
		vendor.code = "NEWVENDOR";
		return vendor;
		//validations
		//pre checks
		//DB Calls
		//Post Validation
		//Post Processing
		//Formatting
	}
	
	private void fillVendor() {
		// TODO Auto-generated method stub
		vendors.put("1", x);
		vendors.put("2", y);
		vendors.put("3", z);
		
		
	}
}
