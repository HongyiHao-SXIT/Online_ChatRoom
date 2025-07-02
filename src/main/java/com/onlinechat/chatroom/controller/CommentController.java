package com.onlinechat.chatroom.controller;

import com.onlinechat.chatroom.mapper.UserMapper;
import com.onlinechat.chatroom.mapper.CommentMapper;
import com.onlinechat.chatroom.entity.Comment;
import com.onlinechat.chatroom.entity.User;
import com.onlinechat.chatroom.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;


    @PostMapping("/save")
    public R save(@RequestBody Comment comment) {
        comment.setAccount(AuthUtil.getUserAccount());
        comment.setCreateTime(new Date());
        commentMapper.insert(comment);
        return R.success("");
    }

    @GetMapping("/list")
    public R list(Comment comment) {
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Comment::getRoomId, comment.getRoomId()).orderByAsc(Comment::getCreateTime);

        List<Comment> comments = commentMapper.selectList(wrapper);

        for (Comment item : comments) {
            LambdaQueryWrapper<User> userWrapper = new LambdaQueryWrapper<>();
            userWrapper.eq(User::getAccount, item.getAccount());

            User user = userMapper.selectOne(userWrapper);
            item.setIcon(user.getIcon());
        }

        return R.data(comments);
    }
}

