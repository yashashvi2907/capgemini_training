package com.capgi.bank.entity.dto;

public class AccountDto {

    private Long balance;
    private AccountType accountType;
    private Integer accountId;
    private String accountHolderName;

    public AccountType getAccountType() {
        
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountSecureKey() {
    }

    public String getHolderEmail() {
    }
}
