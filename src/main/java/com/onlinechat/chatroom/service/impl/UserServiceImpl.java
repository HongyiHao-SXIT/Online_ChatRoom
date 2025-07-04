package com.onlinechat.chatroom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.onlinechat.chatroom.entity.User;
import com.onlinechat.chatroom.repository.UserRepository;
import com.onlinechat.chatroom.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void register(String account, String password, String icon, String remaek) {
        User existingUser = userRepository.findByAccount(account);
        if (existingUser != null) {
            throw new RuntimeException("账号已存在！");
        }

        String encodedPwd = passwordEncoder.encode(password);

        User user = new User();
        user.setAccount(account);
        user.setPassword(encodedPwd);
        user.setIcon(icon);
        user.setRemark(remaek);

        userRepository.save(user);
    }

    @Override
    public String login(String account, String password){
        User user = userRepository.findByAccount(account);
    if (user == null) {
        throw new RuntimeException("账号不存在");
    }

    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new RuntimeException("密码错误");
    }
    String token = jwtService.generateToken(user);

    return token;
}
