package com.onlinechat.chatroom.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinechat.chatroom.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByAccount(String account);
}

