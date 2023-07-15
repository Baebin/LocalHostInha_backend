package com.piebin.web.dto;

import lombok.Data;

@Data
public class CommentRequestDto {
    private int account_idx;
    private int post_idx;
    private String text;
}
