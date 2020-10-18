package com.spring.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.exception.MissingDataException;
import com.spring.boot.exception.RecordNotFoundException;
import com.spring.boot.model.Account;
import com.spring.boot.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account create(Account account) {
		if (account != null) {
			account.setId(null);
			return accountRepository.save(account);
		} else {
			throw new MissingDataException("You need to provide a valid resource.");
		}

	}

	@Override
	public Account update(UUID id, Account account) {

		Optional<Account> updateAccount = accountRepository.findById(id);
		if (updateAccount.isPresent()) {
			account.setId(id);
			return accountRepository.save(account);
		} else {
			throw new RecordNotFoundException("Account not found Id =" + id);
		}
	}

	@Override
	public void delete(UUID id) {
		Optional<Account> deleteAccount = accountRepository.findById(id);
		if (deleteAccount.isPresent()) {
			accountRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("Account not found Id =" + id);
		}

	}

	@Override
	public Account getAccount(UUID id) {
		Optional<Account> findAccount = accountRepository.findById(id);
		if (findAccount.isPresent()) {
			return findAccount.get();
		} else {
			throw new RecordNotFoundException("Account not found Id =" + id);
		}
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

}
