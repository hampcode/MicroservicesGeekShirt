package com.geekshirt.customerservice.util;

import com.geekshirt.customerservice.dto.AccountDto;
import com.geekshirt.customerservice.entities.Account;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountConverter {

    @Autowired
    private ModelMapper modelMapper;

    public AccountDto convertAccountToDto(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }

    public Account convertAccountToEntity(AccountDto account) {
        return modelMapper.map(account, Account.class);
    }

    public Account map(Account accountToUpdate, Account account) {
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(accountToUpdate, account);
        return account;
    }
}
