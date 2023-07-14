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
            JsonArray ja = new JsonArray();

            Account account = optional.get();
            JsonObject jo_post = new JsonObject();
            jo_post.addProperty("name", account.getName());
            jo_post.addProperty("role", account.getRole());
            jo_post.addProperty("email", account.getEmail());
            jo_post.addProperty("uid", account.getIdx());
            ja.add(jo_post);

            jo.add("data", ja);
        }
        return jo.toString();
    }
}
