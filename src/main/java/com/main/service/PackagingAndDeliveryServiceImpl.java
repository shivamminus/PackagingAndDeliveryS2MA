package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dto.PackagingAndDeliveryDTO;
import com.main.exception.ComponentTyepNotFoundException;
import com.main.model.PackagingAndDelivery;
import com.main.util.Constants;

@Service
public class PackagingAndDeliveryServiceImpl implements PackagingAndDeliveryService {

	@Autowired
	PackagingAndDelivery packagingAndDelivery;

	int totalCharge = 0;

	/*
	 * This function will calculate packaging and delivery charges
	 * 
	 * @header String token
	 * 
	 * @params String type
	 * 
	 * @params String count
	 * 
	 * @return PackagingAndDeliveryDTO
	 * 
	 */
	@Override
	public PackagingAndDeliveryDTO calculatePackagingAndDeliveryCharge(String type, Integer count) {

		if (("Integral").equalsIgnoreCase(type)) { // Check for Integral type
			System.out.println("Integral");
			packagingAndDelivery.setPackagingCost(Constants.INTEGRAL_PACKAGING_COST);
			packagingAndDelivery.setDeliveryCost(Constants.INTEGRAL_DELIVERY_COST);

		} else if (("Accessory").equalsIgnoreCase(type)) { // Check for Accessory type
			System.out.println("Accessory");
			packagingAndDelivery.setPackagingCost(Constants.ACCESSORY_DELIVERY_COST);
			packagingAndDelivery.setDeliveryCost(Constants.ACCESSORY_PACKAGING_COST);
		} else if (("Protective sheath").equalsIgnoreCase(type)) {
			packagingAndDelivery.setPackagingCost(Constants.PROTECTIVE_SHEATH_PACKAGING_COST);
			packagingAndDelivery.setDeliveryCost(Constants.PROTECTIVE_SHEATH_DELIVERY_COST);
		} else {
			throw new ComponentTyepNotFoundException("Component Type: " + type + " not found.");
		}

		totalCharge = (packagingAndDelivery.getPackagingCost() + packagingAndDelivery.getDeliveryCost()) * count; // Calculating
																													// total
																													// charge
		System.out.println("" + totalCharge);

		return new PackagingAndDeliveryDTO(totalCharge);

	}

}
