package com.anubhavtrainings.myclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {
	
	private int length;
	private int weight;
	private int height;
	private String brandName;
	@Autowired
	private IHardDisk hdd;
	
//	public Laptop() {
//		//tight coupling
//		//we have to write code to create object
//		hdd = new SamsungHDD();
//		
//	}
	public int getLength() {
		return length;
	}
	@Override
	public String toString() {
		hdd.powerOnHDD();
		hdd.readHDD();
		return "Laptop ["  + " brandName=" + brandName + "]";
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
