package com.spring.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.exception.MissingDataException;
import com.spring.boot.exception.RecordNotFoundException;
import com.spring.boot.model.Organization;
import com.spring.boot.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;

	@Override
	public Organization create(Organization org) {
		if (org != null) {
			org.setId(null);
			return organizationRepository.save(org);
		} else {
			throw new MissingDataException("You have to provide valid resource.");
		}
	}

	@Override
	public Organization update(UUID id, Organization org) {
		Optional<Organization> updateOrg = organizationRepository.findById(id);
		if (updateOrg.isPresent()) {
			org.setId(id);
			return organizationRepository.save(org);
		} else {
			throw new RecordNotFoundException("Organization not found Id=" + id);
		}
	}

	@Override
	public void delete(UUID id) {
		Optional<Organization> deleteOrg = organizationRepository.findById(id);
		if (deleteOrg.isPresent()) {
			organizationRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("Organization not found Id=" + id);
		}

	}

	@Override
	public Organization getOrganization(UUID id) {
		Optional<Organization> findOrg = organizationRepository.findById(id);
		if (findOrg.isPresent()) {
			return findOrg.get();
		} else {
			throw new RecordNotFoundException("Organization not found Id=" + id);
		}
	}

	@Override
	public List<Organization> getAllOrganizations() {
		return organizationRepository.findAll();
	}

}
