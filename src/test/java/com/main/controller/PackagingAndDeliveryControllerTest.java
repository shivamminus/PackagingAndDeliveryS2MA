package com.main.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.main.client.AuthClient;
import com.main.dto.PackagingAndDeliveryDTO;
import com.main.dto.ValidatingDTO;
import com.main.exception.InvalidTokenException;
import com.main.service.PackagingAndDeliveryService;

import feign.FeignException.InternalServerError;


@SpringBootTest
public class PackagingAndDeliveryControllerTest {
    
	@InjectMocks
	PackagingAndDeliveryController packagingAndDeliveryController;
	
	@Mock
	PackagingAndDeliveryService packagingAndDeliveryService;
	

	@Mock
	private AuthClient authClient;
	
	
	/*
	 * Test for PackagingAnddeliveryController is LOADING OR NOT
	 */
	@Test
    @DisplayName("Checking if PackagingAndDeliveryController is working or not.")
    void packagingAndDeliveryControllerIsLoaded(){
        assertThat(packagingAndDeliveryController).isNotNull();    
    }
	

	
	/*
	 * Test for PackagingAnddelivery Controller for SUCCESSFUL RESPONSE
	 */
	@Test
	public void testCalculatePackagingAndDeliveryCharge() {
		String token = "token";
		when(authClient.getsValidity(token)).thenReturn(new ValidatingDTO(true));
		when(packagingAndDeliveryService.calculatePackagingAndDeliveryCharge("Accesory", 4)).thenReturn(new PackagingAndDeliveryDTO(600));
		
		assertEquals(200, packagingAndDeliveryController.calculatePackagingAndDeliveryCharge("Accessory", 4, token).getStatusCodeValue());
		
	}
	
	/*
	 * Test for PackagingAnddelivery Controller for Unauthorized Response
	 */
	@Test
	public void testCalculatePackagingAndDeliveryChargeFailed() throws InvalidTokenException{
		String token = "token";
		try {
			
		when(authClient.getsValidity(token)).thenReturn(new ValidatingDTO(false));
		when(packagingAndDeliveryService.calculatePackagingAndDeliveryCharge("Accessory", 4)).thenReturn(new PackagingAndDeliveryDTO(600));
		
		} catch (InvalidTokenException invalid) {
			assertEquals(403, packagingAndDeliveryController.calculatePackagingAndDeliveryCharge("Accessory", 4, token).getStatusCodeValue());			
		}
		
	}
	
	/*
	 * Test for PackagingAnddelivery Controller for BAD REQUEST
	 */
	@Test
	public void testCalculatePackagingAndDeliveryChargeFailedError() {
		String token = "token";
		
		when(authClient.getsValidity(token)).thenReturn(new ValidatingDTO(true));
		when(packagingAndDeliveryService.calculatePackagingAndDeliveryCharge("Accessory", 4)).thenThrow(InternalServerError.class);
		
		assertEquals(500, packagingAndDeliveryController.calculatePackagingAndDeliveryCharge("Accessory", 4, token).getStatusCodeValue());
		
	}
	
	
}
