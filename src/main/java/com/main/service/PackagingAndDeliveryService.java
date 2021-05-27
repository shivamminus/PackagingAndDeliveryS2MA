package com.main.service;

import org.springframework.stereotype.Service;

import com.main.dto.PackagingAndDeliveryDTO;

@Service
public interface PackagingAndDeliveryService {

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
	public PackagingAndDeliveryDTO calculatePackagingAndDeliveryCharge(String Type, Integer count);

}
