package com.restFulApi.contactManagement.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restFulApi.contactManagement.entity.Contact;

@Repository
@Transactional
public interface ContactRepository extends JpaRepository<Contact, Long> {
	
}
