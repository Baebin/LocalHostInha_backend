package com.piebin.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AccountRequestDto {
    private String id;
    private String name;
    private String pw;
    private String email;
}