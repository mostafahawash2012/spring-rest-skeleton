package com.spring.boot.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.spring.boot.model.Account;
import com.spring.boot.model.OrgGroup;
import com.spring.boot.model.Organization;
import com.spring.boot.model.User;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ServicesTest {

	@Autowired
	UserService userService;
	@Autowired
	OrganizationService orgService;
	@Autowired
	OrgGroupService groupService;
	@Autowired
	AccountService accountService;

	@Test
	public void testCreate() {
		// given
		userService.create(ObjectBuilder.buildUser());
		orgService.create(ObjectBuilder.buildOrg());
		groupService.create(ObjectBuilder.buildGroup());
		accountService.create(ObjectBuilder.buildAccount());
	}

	@Test
	public void testAddAccount() {
		User user = userService.create(ObjectBuilder.buildUser());
		Set<Account> accounts = new HashSet<Account>();
		accounts.add(ObjectBuilder.buildAccount());
		user.setAccounts(accounts);
		userService.update(user.getId(), user);
	}

	@Test
	public void testAddGroup() {
		User user1 = userService.create(ObjectBuilder.buildUser());

		User user2 = ObjectBuilder.buildUser();
		user2.setName("user2");
		OrgGroup gp2 = ObjectBuilder.buildGroup();
		gp2.setName("group2");

		user2 = userService.create(user2);
		Organization org = orgService.create(ObjectBuilder.buildOrg());
		OrgGroup gp = groupService.create(ObjectBuilder.buildGroup());
		gp.setOrganization(org);
		gp.setUser(user1);
		gp2.setOrganization(org);
		gp2.setUser(user2);
		groupService.create(gp);
		groupService.create(gp2);
		Organization updatedOrg = orgService.getOrganization(org.getId());
		User updatedUser1 = userService.getUser(user1.getId());
		User updatedUser2 = userService.getUser(user2.getId());
		assertThat(updatedUser1.getGroups().size()).isSameAs(1);
		assertThat(updatedUser2.getGroups().size()).isSameAs(1);
		assertThat(updatedOrg.getGroups().size()).isSameAs(2);

	}
}
