package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dto.PackagingAndDeliveryDTO;
import com.main.exception.ComponentTyepNotFoundException;
import com.main.model.PackagingAndDelivery;

import lombok.extern.slf4j.Slf4j;

@Service
public class PackagingAndDeliveryServiceImpl implements PackagingAndDeliveryService {



	@Autowired
	PackagingAndDelivery packagingAndDelivery;

	int totalCharge = 0;

	@Override
	public PackagingAndDeliveryDTO calculatePackagingAndDeliveryCharge(String type, Integer count) {
		System.out.println("=========Begin======calculatePackagingAndDeliveryCharge()");
		if (("Integral").equalsIgnoreCase(type)) {
			System.out.println("Integral");
			packagingAndDelivery.setPackagingCost(100);
			packagingAndDelivery.setDeliveryCost(200);

		} else if (("Accessory").equalsIgnoreCase(type)) {
			System.out.println("Accessory");
			packagingAndDelivery.setPackagingCost(50);
			packagingAndDelivery.setDeliveryCost(100);
		} else if (("Protective sheath").equalsIgnoreCase(type)) {
			packagingAndDelivery.setPackagingCost(50);
		} else {
			throw new ComponentTyepNotFoundException("Component Type: " + type + " not found.");
		}

		totalCharge = (packagingAndDelivery.getPackagingCost() + packagingAndDelivery.getDeliveryCost()) * count;
		System.out.println("" + totalCharge);
		System.out.println("=========End======calculatePackagingAndDeliveryCharge()");

		return new PackagingAndDeliveryDTO(totalCharge);

	}

}
