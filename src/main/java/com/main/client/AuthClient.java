package com.main.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.main.dto.ValidatingDTO;


//@FeignClient(name = "AUTH-SERVICE", url = "http://localhost:9090/auth")
@FeignClient(name = "AUTH-SERVICE", url = "http://localhost:8081/auth")

public interface AuthClient {
	
	 @GetMapping(value = "/validate")
     public ValidatingDTO getsValidity(@RequestHeader(name = "Authorization", required = true) String token);

}
