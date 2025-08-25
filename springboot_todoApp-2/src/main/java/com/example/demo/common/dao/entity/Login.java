package com.example.demo.common.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "login")  // "user" はDBの予約語なので "users" 推奨
@Getter
@Setter
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "ユーザー名は必須です")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "パスワードは必須です")
    private String password;
}