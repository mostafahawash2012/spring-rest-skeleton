package com.spring.boot.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class OrgGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
	@Column(name = "id", columnDefinition = "VARCHAR(255)", insertable = false, updatable = false, nullable = false)
	private UUID id;

	private String name;

	@ManyToOne // (cascade = CascadeType.ALL)
	@JoinColumn(name = "organization_id")
	private Organization organization;

	@ManyToOne // (cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

}
