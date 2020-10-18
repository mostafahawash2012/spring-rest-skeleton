package com.spring.boot.service;

import java.util.List;
import java.util.UUID;

import com.spring.boot.model.Account;

public interface AccountService {

	Account create(final Account account);

	Account update(final UUID id, final Account account);

	void delete(final UUID id);

	Account getAccount(final UUID id);

	List<Account> getAllAccounts();
}
