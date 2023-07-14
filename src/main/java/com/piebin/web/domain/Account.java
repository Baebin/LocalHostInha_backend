package com.piebin.web.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
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

    @NonNull
    @Builder.Default
    private Long point = 0L;

    @JsonIgnore
    @CreatedDate
    private LocalDateTime registration_date;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @Builder.Default
    private Set<Post> posts = new HashSet<>();

    // NoArgsConstructor
    public Account() {}

    public Account(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Account(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void addPost(Post post) {
        posts.add(post);
        post.setAccount(this);
    }
}
