package com.anubhavtrainings.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anubhavtrainings.entities.Vendor;
import com.anubhavtrainings.service.vendorService;

@RestController

public class VendorController {

	@Autowired
	vendorService vendorService;
	
	//ES_GET_ENTITYSET
	@RequestMapping("/vendor")
	public HashMap<String, Vendor> getVendors(){
		return vendorService.readAllVendors();		
	}
	
	//ES_GET_ENTITY
	@RequestMapping("/vendor/{vendorCode}")
	public Vendor getVendorById(@PathVariable("vendorCode") String code) {
		return vendorService.getSingleVendorById(code);
	}
	
	//ES_CREATE_ENTITY
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		return vendorService.createVendor(myPostBody);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/changeVendor")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return vendorService.changeVendor(vendor);
	}
	
	
	
	
}
