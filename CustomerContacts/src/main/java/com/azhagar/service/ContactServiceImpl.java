package com.azhagar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.model.Contact;
import com.azhagar.repository.IContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	private IContactRepository repo;

	@Override
	public String saveContact(Contact contact) {
		if (repo.save(contact).getContactId() != null)
			return "Contact Saved";
		return "Contact Failed To saved";

	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repo.findById(contactId);
		if (findById.isPresent())
			return findById.get();
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
		if (repo.existsById(contact.getContactId())) {
			repo.save(contact).getContactId();
			return "Contact Updated";
		} else {
			return "Contact Not Exist To Update";
		}

	}

	@Override
	public String deleteContactById(Integer contactId) {
		if (repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "Contact Deleted";
		} else {
			return "Record not found to delete";
		}
	}

}
