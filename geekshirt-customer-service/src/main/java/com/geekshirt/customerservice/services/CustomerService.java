package com.geekshirt.customerservice.services;

import com.geekshirt.customerservice.entities.Account;
import com.geekshirt.customerservice.exceptions.AccountNotFoundException;
import com.geekshirt.customerservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private AccountRepository accountRepository;

    public Account findAccountById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        return account.orElseThrow(() -> new AccountNotFoundException(id.toString()));
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }
}
