package com.piebin.web.service;

import com.piebin.web.domain.Account;
import com.piebin.web.dto.AccountRequestDto;
import com.piebin.web.entity.Authority;
import com.piebin.web.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;

    @Transactional
    public Account register(AccountRequestDto dto) {
        Account account = new Account(
                dto.getId(),
                dto.getPw()
        );
        account.setName(dto.getId());
        account.setRegistration_date(LocalDateTime.now());
        account.setRole(Authority.ROLE_USER.name());
        return repository.save(account);
    }
}
