package com.restfulapijpa.studentmanagement.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.restfulapijpa.studentmanagement.entity.Contact;

@FeignClient(name="contact-management")
public interface ContactProxy {
	
	@GetMapping("/contact")
	List<Contact> getContact();


}
