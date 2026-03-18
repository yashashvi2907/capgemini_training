package com.capgi.bank.config;

import com.capgi.bank.entity.Account;
import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;

public class CustomMapper {

//    public static AccountResponseDto mapAccountToResponse(Account account, AccountResponseDto accountResponseDto)
//    {
//        accountResponseDto.setAccountType(account.getAccountType());
//        accountResponseDto.setAccountId(account.getAccountId());
//        accountResponseDto.setAccountHolderName(account.getAccountholderName());
//        accountResponseDto.setBalance(account.getBalance());
//        return
//
//
//    }

    public static Account mapAccountDtoToAccount(AccountDto accountDto, Account account)
    {
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setAccountType(accountDto.getAccountType());
        account.setAccountSecureKey(accountDto.getAccountSecureKey());
        account.setHolderEmail(accountDto.getHolderEmail());
        account.setBalance(accountDto.getBalance());
        return account;
    }

}
