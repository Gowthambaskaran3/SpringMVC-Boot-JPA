package com.restFulApi.contactManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restFulApi.contactManagement.entity.Contact;
import com.restFulApi.contactManagement.repository.ContactRepository;


@RestController
public class ContactController {

	@Autowired
	ContactRepository contactRepository;

	@GetMapping("/contact")
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@GetMapping("/contact/{id}")
	public Optional<Contact> findById(@PathVariable Long id) {
		Optional<Contact> contact = contactRepository.findById(id);
		return contact;
	}

	@PostMapping("/contact")
	public void save(@RequestBody Contact contact) {
		contactRepository.save(contact);
	}

	@DeleteMapping("/contact/{id}")
	public void delete(@PathVariable Long id) throws ContactNotFoundException {

		Optional<Contact> contact = contactRepository.findById(id);

		if (contact == null)
			throw new ContactNotFoundException("id");

		else {
			contactRepository.deleteById(id);
		}
	}
//
//	@PutMapping("/contact")
//	public void update(@RequestBody Contact contact) {
//		contactRepository.update(contact);
//	}
}
