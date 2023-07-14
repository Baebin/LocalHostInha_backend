package com.piebin.web.dto;

import lombok.Data;

@Data
public class PostSaveRequestDto {
    private String id;
    private String title;
    private String description;
}
