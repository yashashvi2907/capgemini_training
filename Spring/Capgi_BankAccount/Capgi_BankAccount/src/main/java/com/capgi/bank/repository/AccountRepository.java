package com.capgi.bank.repository;

import com.capgi.bank.entity.Account;
import com.capgi.bank.services.AccountService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {



}
