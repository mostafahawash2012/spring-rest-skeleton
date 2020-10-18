package com.spring.boot.service;

import java.util.List;
import java.util.UUID;

import com.spring.boot.model.Organization;

public interface OrganizationService {

	Organization create(final Organization org);

	Organization update(final UUID id, final Organization org);

	void delete(final UUID id);

	Organization getOrganization(final UUID id);

	List<Organization> getAllOrganizations();
}
