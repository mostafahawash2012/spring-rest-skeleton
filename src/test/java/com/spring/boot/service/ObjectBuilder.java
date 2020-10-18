package com.spring.boot.service;

import com.spring.boot.model.Account;
import com.spring.boot.model.AccountTypesEnum;
import com.spring.boot.model.OrgGroup;
import com.spring.boot.model.Organization;
import com.spring.boot.model.User;

public class ObjectBuilder {

	public static User buildUser() {
		User user = new User();
		user.setEmail("user1@gmail.com");
		user.setName("user1");
		return user;
	}

	public static Account buildAccount() {
		Account account = new Account();
		account.setLogin("user1");
		account.setType(AccountTypesEnum.HDS);

		return account;
	}

	public static Organization buildOrg() {
		Organization org = new Organization();
		org.setName("org1");
		return org;
	}

	public static OrgGroup buildGroup() {
		OrgGroup gp = new OrgGroup();
		gp.setName("group1");
		return gp;
	}
}
