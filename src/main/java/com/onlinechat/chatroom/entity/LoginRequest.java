package com.onlinechat.chatroom.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public static class LoginRequest {
    private String account;
    private String password;
}
