package com.capgi.bank.services;

import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;

public interface AccountService {
    void createAccount(AccountDto accountDto);

    AccountResponseDto getAccountById(Integer id);
}
