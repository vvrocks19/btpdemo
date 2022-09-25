package com.anubhavtrainings.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.businesslogic.vendorOperation;
import com.anubhavtrainings.entities.vendor;

@RestController
public class vendorController {
	
	@Autowired
	vendorOperation vendorRepo;
	
	@RequestMapping("/vendors")
	public List<vendor> getAllVendors(){
		return vendorRepo.getAllVendors();
	}
	
	@RequestMapping("/vendors/{id}")
	public vendor getVendorById(@PathVariable("id") String id) throws SQLException {
		return vendorRepo.getSingleVendor(id);
	}
	
	@PostMapping("/vendor")
	public vendor createNewVendor(@RequestBody vendor myPostBody) throws SQLException {
		return vendorRepo.createVendor(myPostBody);
	}
	
}
