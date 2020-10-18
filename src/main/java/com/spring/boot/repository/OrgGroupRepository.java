package com.spring.boot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.model.OrgGroup;

@Repository
public interface OrgGroupRepository extends JpaRepository<OrgGroup, UUID> {

}
