package com.anubhavtrainings.entities;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.olingo.odata2.api.edm.EdmEntitySet;
import org.springframework.beans.factory.annotation.Autowired;

import com.anubhavtrainings.annotation.processor.ODataInterface;
import com.anubhavtrainings.service.IAddressPersistence;

public class AddressOdataAgent implements ODataInterface {

	
	@Autowired
	IAddressPersistence addressAPI;	
	
	@Override
	public List<?> getEntitySet() {
		// TODO Auto-generated method stub
		return addressAPI.findAll();
	}

	@Override
	public Object getEntity(Map<String, ?> keys) {
		// TODO Auto-generated method stub
		return addressAPI.findById((String)keys.get("AddressId")).get();
	}

	@Override
	public List<?> getRelatedEntity(Object source, String relatedEntityName, Map<String, Object> keys,
			Field sourceField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEntity(Object dataToCreate) {
		// TODO Auto-generated method stub
		addressAPI.save((address)dataToCreate);
	}

	@Override
	public void deleteEntity(Map<String, ?> keys) {
		// TODO Auto-generated method stub
		addressAPI.findById((String)keys.get("AddressId"));
	}

	@Override
	public void updateEntity(Object dataToUpdate) {
		// TODO Auto-generated method stub
		addressAPI.save((address)dataToUpdate);
	}

	@Override
	public void writeRelation(EdmEntitySet sourceEntitySet, Object sourceData, EdmEntitySet targetEntitySet,
			Map<String, Object> targetKeys) {
		// TODO Auto-generated method stub
		Vendor vendor = (Vendor)sourceData;
 		Optional<address> existingAddr = addressAPI.findById((String) targetKeys.get("AddressId"));
		address newAddr = existingAddr.get();
		newAddr.setVendor(vendor);
		addressAPI.save(newAddr);
 		
	}

}
