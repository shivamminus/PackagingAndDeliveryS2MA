package com.main.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class PackagingAndDeliveryControllerTest {
    
	@Autowired
	PackagingAndDeliveryController packagingAndDeliveryController;
	
	@Test
    @DisplayName("Checking if PackagingAndDeliveryController is working or not.")
    void packagingAndDeliveryControllerIsLoaded(){
        assertThat(packagingAndDeliveryController).isNotNull();    
    }
	
	@Test
	 void testHealthCheck() {
		
		assertEquals("200 OK",packagingAndDeliveryController.healthCheck().getStatusCode().toString());
		
	}
	
	
}
