package com.onlinechat.chatroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinechat.chatroom.common.utils.AuthUtil;
import com.onlinechat.chatroom.entity.Result;
import com.onlinechat.chatroom.entity.User;
import com.onlinechat.chatroom.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginOut")
    public Result loginOut() {
        AuthUtil.clear();
        return Result.success();
    }
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        
        return Result.success();
    }


}

/*
    @GetMapping("/current")
    public R current() {
        User user = AuthUtil.getUser();
        return R.data(user);
    }

    @PostMapping("/register")
    public R register(@RequestBody User user) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getAccount, user.getAccount());
        Long count = userMapper.selectCount(wrapper);

        if (count > 0) {
            throw new ServiceException("账号已存在");
        }

        user.setPassword(AuthUtil.codePassword(user.getPassword()));
        userMapper.insert(user);
        return R.success("注册成功");
    }

    @PostMapping("/login")
    public R login(@RequestBody User user) {
        AuthUtil.clear();

        user.setPassword(AuthUtil.codePassword(user.getPassword()));

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getAccount, user.getAccount());
        wrapper.eq(User::getPassword, user.getPassword());
        User exist = userMapper.selectOne(wrapper);

        if (exist == null) {
            return R.fail("用户名或密码错误");
        }

        AuthUtil.setToken(exist);
        return R.success("登录成功");
    }

    @PostMapping("/update")
    public R update(@RequestBody User user) {
        userMapper.updateById(user);
        AuthUtil.setToken(user);
        return R.success("");
    }
}
*/
