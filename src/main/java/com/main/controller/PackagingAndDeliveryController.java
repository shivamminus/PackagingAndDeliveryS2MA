package com.main.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.PackagingAndDeliveryS2MaApplication;
import com.main.client.AuthClient;
import com.main.dto.PackagingAndDeliveryDTO;
import com.main.exception.InvalidTokenException;
import com.main.exception.SomethingWentWrong;
import com.main.service.PackagingAndDeliveryService;

import feign.FeignException;

@RestController
@RequestMapping(value = "/packagedelivery")
public class PackagingAndDeliveryController {
	
	private static Logger logger = LoggerFactory.getLogger(PackagingAndDeliveryController.class);


	@Autowired
	private PackagingAndDeliveryService packagingAndDeliveryService;
	@Autowired
	private AuthClient authClient;

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
	 */
	@PostMapping(path = "/getPackagingDeliveryCharge/{type}/{count}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> calculatePackagingAndDeliveryCharge(@PathVariable String type,
			@PathVariable Integer count, @RequestHeader(name = "Authorization", required = true) String token)
			throws InvalidTokenException {

		if (!authClient.getsValidity(token).isValidStatus()) {

			throw new InvalidTokenException("Token is either expired or invalid...");

		}

		try {
			return new ResponseEntity<>(packagingAndDeliveryService.calculatePackagingAndDeliveryCharge(type, count),
					HttpStatus.OK);

		} catch (Exception serverError) {
			return new ResponseEntity<>("Sorry Something went wrong, try again later",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
