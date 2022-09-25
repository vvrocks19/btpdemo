package com.anubhavtrainings.businesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.anubhavtrainings.entities.vendor;
import com.sap.db.jdbcext.wrapper.PreparedStatement;

import argo.jdom.*;
import argo.saj.InvalidSyntaxException;

@Component
public class vendorOperation {
	
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	String url;
	String user;
	String password;
	
	@PostConstruct
	public void startConnection() {
		
		this.url = "";
		this.user = "";
		this.password = "";
		
		//We obtain the JSON String of VCAP Services
		String vcap_service = System.getenv("VCAP_SERVICES");
		System.out.println(vcap_service);
		if(vcap_service != null && vcap_service.length() > 0) {
			
			try {
				JsonNode root = new JdomParser().parse(vcap_service);
				JsonNode serviceRoot =  root.getNode("hanatrial");
				JsonNode cred = serviceRoot.getNode(0).getNode("credentials");
				
				this.url = cred.getStringValue("url");
				this.user = cred.getStringValue("user");
				this.password = cred.getStringValue("password");
				
			} catch (InvalidSyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Dude Error in VCAP_SERVICE");
			}
			
			try {
				conn = DriverManager.getConnection(this.url, this.user, this.password);
				stmt = conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("!!DB Connection Failed!!");
			}
		}
	}
	
	public List<vendor> getAllVendors(){
		
		List<vendor> vendorList = new ArrayList<vendor>();
		
		try {
			rs = stmt.executeQuery("SELECT top 100 * from VENDOR");
			
			while(rs.next()) {
				vendorList.add(new vendor(
							rs.getString("ID"),
							rs.getString("FIRSTNAME"),
							rs.getString("LASTNAME"),
							rs.getString("COMPANYNAME"),
							rs.getString("WEBSITE"),
							rs.getString("EMAIL"),
							rs.getString("VSTATUS"),
							rs.getString("GSTNUMBER")
						));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vendorList;
	}
	
	public vendor createVendor(vendor payload) throws SQLException {
		String lv_query = "INSERT INTO VENDOR (id, firstname, lastname, companyname) VALUES('" + payload.getId() + "','" + payload.getFirstName() + "','" + payload.getLastName() + "','" + payload.getCompanyName() +"')";
		//PreparedStatement prpStmt = (PreparedStatement) conn.prepareStatement(lv_query);
		
		int row = stmt.executeUpdate(lv_query);
		
//		prpStmt.setString(1, payload.getId());
//		prpStmt.setString(2, payload.getFirstName());
//		prpStmt.setString(3, payload.getLastName());
//		prpStmt.setString(4, payload.getCompanyName());
//		prpStmt.setString(5, payload.getWebsite());
//		prpStmt.setString(6, payload.getEmail());
//		prpStmt.setString(7, payload.getGstNumber());
		
		
		//int row = prpStmt.executeUpdate();
		
		return payload;
		
	}
	
	public vendor getSingleVendor(String id) throws SQLException {
		
		vendor vendorObj = new vendor();
		rs = stmt.executeQuery("SELECT * from VENDOR where id = " + id );
		while(rs.next()) {
			vendorObj.setId(rs.getString("ID"));
			vendorObj.setFirstName(rs.getString("FIRSTNAME"));
			vendorObj.setLastName(rs.getString("LASTNAME"));
			vendorObj.setEmail(rs.getString("EMAIL"));
			vendorObj.setCompanyName(rs.getString("COMPANYNAME"));
			vendorObj.setGstNumber(rs.getString("GSTNUMBER"));
		}
		
		return vendorObj;
		
	}
	
	
	@PreDestroy
	public void endConnection() throws SQLException {
		rs.close();
		stmt.close();
		conn.close();
	}
	
}
