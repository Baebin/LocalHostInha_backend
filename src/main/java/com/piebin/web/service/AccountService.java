package com.piebin.web.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.piebin.web.domain.Account;
import com.piebin.web.domain.Post;
import com.piebin.web.dto.AccountGetInfoRequestDto;
import com.piebin.web.dto.AccountRequestDto;
import com.piebin.web.entity.Authority;
import com.piebin.web.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;

    @Transactional
    public Account register(AccountRequestDto dto) {
        Account account = new Account(
                dto.getId(),
                dto.getName(),
                dto.getPw(),
                dto.getEmail()
        );
        account.setRegistration_date(LocalDateTime.now());
        account.setRole(Authority.ROLE_USER.name());
        return repository.save(account);
    }

    public String getInfo(AccountGetInfoRequestDto dto) {
        Optional<Account> optional = repository.findById(dto.getId());

        JsonObject jo = new JsonObject();
        if (optional.isPresent()) {
            Account account = optional.get();
            jo.addProperty("name", account.getName());
            jo.addProperty("role", account.getRole());
            jo.addProperty("email", account.getEmail());
            jo.addProperty("uid", account.getIdx());
        }
        return jo.toString();
    }
}
