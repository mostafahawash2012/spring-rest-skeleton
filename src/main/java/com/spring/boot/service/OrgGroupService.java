package com.spring.boot.service;

import java.util.List;
import java.util.UUID;

import com.spring.boot.model.OrgGroup;

public interface OrgGroupService {

	OrgGroup create(final OrgGroup group);

	OrgGroup update(final UUID id, final OrgGroup org);

	void delete(final UUID id);

	OrgGroup getGroup(final UUID id);

	List<OrgGroup> getAllGroups();
}
