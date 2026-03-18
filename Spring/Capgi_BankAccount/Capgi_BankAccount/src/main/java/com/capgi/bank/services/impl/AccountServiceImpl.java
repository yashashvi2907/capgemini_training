package com.capgi.bank.services.impl;


import com.capgi.bank.config.CustomMapper;
import com.capgi.bank.entity.Account;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;
import com.capgi.bank.repository.AccountRepository;
import com.capgi.bank.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void createAccount(AccountDto accountDto) {

//        Account account = new Account();
//        account.setAccountHolderName(accountDto.getAccountHolderName());
//        account.setAccountType(accountDto.getAccountType());
//        account.setAccountSecureKey(accountDto.getAccountSecureKey());
//        account.setHolderEmail(accountDto.getHolderEmail());
//        account.setBalance(accountDto.getBalance());
        Account account = CustomMapper.mapAccountDtoToAccount(accountDto, new Account());

        accountRepository.save(account);
    }

    @Override
    public AccountResponseDto getAccountById(Integer id) {

        Optional<Account> account = accountRepository.findById(id);
        AccountResponseDto accountDto = modelMapper.map(account, AccountResponseDto.class);
        return accountDto;
    }


}
