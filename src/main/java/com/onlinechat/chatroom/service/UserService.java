package com.onlinechat.chatroom.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void register(String account, String password, String icon, String remaek);
    String login(String account, String password);
}
