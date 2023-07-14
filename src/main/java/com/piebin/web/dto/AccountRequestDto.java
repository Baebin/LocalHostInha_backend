package com.piebin.web.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AccountRequestDto {
    private String id;
    private String pw;
    private String name;
    private String email;
}