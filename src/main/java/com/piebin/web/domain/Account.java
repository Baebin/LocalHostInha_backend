package com.piebin.web.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Account {
    @Id
    @Column(name = "idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @NonNull
    @Column(unique = true)
    private String id;
    private String name;
    @NotNull
    private String password;
    @Column(unique = true)
    private String email;
    @NonNull
    private String role;

    @CreatedDate
    private LocalDateTime registration_date;

    @Builder
    public Account(String id, String password) {
        this.id = id;
        this.password = password;
    }
}
