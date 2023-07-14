package com.piebin.web.domain;

import com.piebin.web.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Comment {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String text;

    @CreatedDate
    private LocalDateTime created_time;

    @LastModifiedDate
    private LocalDateTime edited_time;

    // NoArgsConstructor
    public Comment() {}

    public Comment(CommentRequestDto dto) {
        this.text = dto.getText();
    }

    @ManyToOne
    private Post post;

    @ManyToOne
    private Account account;
}
