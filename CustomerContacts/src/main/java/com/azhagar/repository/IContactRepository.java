package com.azhagar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.model.Contact;

public interface IContactRepository extends JpaRepository<Contact, Integer> {

}
