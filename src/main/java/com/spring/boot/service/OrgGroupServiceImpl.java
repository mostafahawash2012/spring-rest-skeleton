package com.spring.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.exception.RecordNotFoundException;
import com.spring.boot.model.OrgGroup;
import com.spring.boot.repository.OrgGroupRepository;

@Service
public class OrgGroupServiceImpl implements OrgGroupService {

	@Autowired
	OrgGroupRepository orgGroupRepository;

	@Override
	public OrgGroup create(OrgGroup group) {
		return orgGroupRepository.save(group);
	}

	@Override
	public OrgGroup update(UUID id, OrgGroup group) {
		Optional<OrgGroup> updateGroup = orgGroupRepository.findById(id);
		if (updateGroup.isPresent()) {
			group.setId(id);
			return orgGroupRepository.save(group);
		} else {
			throw new RecordNotFoundException("Group is not found id =" + id);
		}

	}

	@Override
	public void delete(UUID id) {
		Optional<OrgGroup> deleteGroup = orgGroupRepository.findById(id);
		if (deleteGroup.isPresent()) {
			orgGroupRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("Group is not found id =" + id);
		}

	}

	@Override
	public OrgGroup getGroup(UUID id) {
		Optional<OrgGroup> findGroup = orgGroupRepository.findById(id);
		if (findGroup.isPresent()) {
			return findGroup.get();
		} else {
			throw new RecordNotFoundException("Group is not found id =" + id);
		}
	}

	@Override
	public List<OrgGroup> getAllGroups() {
		return orgGroupRepository.findAll();
	}
}
