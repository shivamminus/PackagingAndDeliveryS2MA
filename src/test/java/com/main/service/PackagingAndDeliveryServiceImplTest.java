package com.main.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PackagingAndDeliveryServiceImplTest {
	
	@Autowired
	private PackagingAndDeliveryServiceImpl packagingAndDeliveryServiceImpl;

	@Test
    @DisplayName("Checking if packagingAndDeliveryServiceImpl is loading or not.")
    void padControllerIsLoaded(){
        assertThat(packagingAndDeliveryServiceImpl).isNotNull();    
    }
	
	
	@Test
    @DisplayName("Checking CalculatePackagingAndDeliveryCharge()")
    void testCalculatePackagingAndDeliveryCharge() {
		
		// Positive Test case
		assertEquals(150,packagingAndDeliveryServiceImpl.calculatePackagingAndDeliveryCharge("accessory", 1).getCharge());
		assertEquals(300,packagingAndDeliveryServiceImpl.calculatePackagingAndDeliveryCharge("integral", 1).getCharge());
		assertEquals(50,packagingAndDeliveryServiceImpl.calculatePackagingAndDeliveryCharge("Protective sheath", 1).getCharge());
		
		// negative test case
		assertNotEquals(21,packagingAndDeliveryServiceImpl.calculatePackagingAndDeliveryCharge("accessory", 1).getCharge());
		assertNotEquals(43,packagingAndDeliveryServiceImpl.calculatePackagingAndDeliveryCharge("integral", 1).getCharge());
		assertNotEquals(567,packagingAndDeliveryServiceImpl.calculatePackagingAndDeliveryCharge("Protective sheath", 1).getCharge());
		
	}

}